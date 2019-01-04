package entity;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import util.DateCreate;
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

    public List<MonthBill> get(Integer household_id, Integer beginYear, Integer beginMonth, Integer endYear, Integer endMonth){
        List<Timestamp> timestamps = DateCreate.create(beginYear,beginMonth,endYear,endMonth);
        String selectProperty = "SELECT * FROM property_fee WHERE household_ID= ? and time between ? and ?";
        Object[] params = new Object[3];
        params[0] = household_id;
        params[1] = timestamps.get(0);
        params[2] = timestamps.get(1);
        Object o = MysqlConnection.select(selectProperty, rs->{
            List<MonthBill> monthBills = new ArrayList<>();
            while (rs.next()){
                boolean paied = rs.getInt("paied") == 1;
                monthBills.add(new MonthBill(rs.getInt("household_ID"),rs.getFloat("amount"), rs.getTimestamp("time"),paied,"property"));
            }
            return monthBills;
        }, params);
        List<MonthBill> monthBillsProperty = (List<MonthBill>)o;
        String selectParking = "SELECT * FROM park_fee WHERE household_ID= ? and time between ? and ?";
        Object b = MysqlConnection.select(selectParking, rs->{
            List<MonthBill> monthBills = new ArrayList<>();
            while (rs.next()){
                boolean paied = rs.getInt("paied") == 1;
                monthBills.add(new MonthBill(rs.getInt("household_ID"),rs.getFloat("amount"),rs.getTimestamp("time"),paied,"property"));
            }
            return monthBills;
        }, params);
        List<MonthBill> monthBillsParking = (List<MonthBill>)b;
        List<MonthBill> monthBills = new ArrayList<>();
        if(null != monthBillsProperty) monthBills.addAll(monthBillsProperty);
        if(null != monthBillsParking) monthBills.addAll(monthBillsParking);
        return monthBills;
    }

    public List<MonthBill> get(){
        String selectProperty = "SELECT * FROM property_fee";
        Object o = MysqlConnection.select(selectProperty, rs->{
            List<MonthBill> monthBills = new ArrayList<>();
            while (rs.next()){
                boolean paied = rs.getInt("paied") == 1;
                monthBills.add(new MonthBill(rs.getInt("household_ID"),rs.getFloat("amount"), rs.getTimestamp("time"),paied,"property"));
            }
            return monthBills;
        });
        List<MonthBill> monthBillsProperty = (List<MonthBill>)o;
        String selectParking = "SELECT * FROM park_fee";
        Object b = MysqlConnection.select(selectParking, rs->{
            List<MonthBill> monthBills = new ArrayList<>();
            while (rs.next()){
                boolean paied = rs.getInt("paied") == 1;
                monthBills.add(new MonthBill(rs.getInt("household_ID"),rs.getFloat("amount"),rs.getTimestamp("time"),paied,"property"));
            }
            return monthBills;
        });
        List<MonthBill> monthBillsParking = (List<MonthBill>)b;
        List<MonthBill> monthBills = new ArrayList<>();
        if(null != monthBillsProperty) monthBills.addAll(monthBillsProperty);
        if(null != monthBillsParking) monthBills.addAll(monthBillsParking);
        return monthBills;
    }
}
