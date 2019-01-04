package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class MonthBillManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public MonthBillManager() {
    }

    private static class SingletonFactory {
        private static MonthBillManager instance = new MonthBillManager();
    }

    public static MonthBillManager getInstance() {
        return MonthBillManager.SingletonFactory.instance;
    }

    public List<MonthBill> get(Integer household_id, Timestamp begin, Timestamp end){
        String selectProperty = "SELECT * FROM property_fee WHERE household_ID= ? and time between ? and ?";
        Object[] params = new Object[3];
        params[0] = household_id;
        params[1] = begin;
        params[2] = end;
        Object o = MysqlConnection.select(selectProperty, rs->{
            List<MonthBill> monthBills = new ArrayList<>();
            while (rs.next()){
                boolean paied = rs.getInt("paied") == 1;
                monthBills.add(new MonthBill(rs.getFloat("amount"), rs.getTimestamp("time"),paied,"property"));
            }
            return monthBills;
        }, params);
        List<MonthBill> monthBillsProperty = (List<MonthBill>)o;
        String selectParking = "SELECT * FROM park_fee WHERE household_ID= ? and time between ? and ?";
        Object b = MysqlConnection.select(selectParking, rs->{
            List<MonthBill> monthBills = new ArrayList<>();
            while (rs.next()){
                boolean paied = rs.getInt("paied") == 1;
                monthBills.add(new MonthBill(rs.getFloat("amount"),rs.getTimestamp("time"),paied,"property"));
            }
            return monthBills;
        }, params);
        List<MonthBill> monthBillsParking = (List<MonthBill>)b;
        List<MonthBill> monthBills = new ArrayList<>();
        if(null != monthBillsProperty) monthBills.addAll(monthBillsProperty);
        if(null != monthBillsParking) monthBills.addAll(monthBillsParking);
        return monthBills;
    }
}
