package entity;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class MonthBillManager implements EntityManager<MonthBill>{
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    private MonthBillManager() {}

    @Override
    public List<MonthBill> get() {
        return new ArrayList<>();
    }

    @Override
    public boolean insert(MonthBill entity) {
        return false;
    }

    @Override
    public boolean update(MonthBill entity) {
        return false;
    }

    @Override
    public boolean delete(MonthBill entity) {
        return false;
    }

    private static class SingletonFactory {
        private static MonthBillManager instance = new MonthBillManager();
    }

    public static MonthBillManager getInstance() {
        return MonthBillManager.SingletonFactory.instance;
    }

    public List<MonthBill> get(Integer household_id, Integer beginYear, Integer beginMonth, Integer endYear, Integer endMonth){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setLenient(false);
        Timestamp begin = null;
        Timestamp end = null;
        try{
            begin = new Timestamp(format.parse(beginYear + "-" + beginMonth +"-1 00:00:00").getTime());
            end = new Timestamp(format.parse(endYear + "-" + endMonth+"-30 00:00:00").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    public List<MonthBill> get(){
        String selectProperty = "SELECT * FROM property_fee";
        Object o = MysqlConnection.select(selectProperty, rs->{
            List<MonthBill> monthBills = new ArrayList<>();
            while (rs.next()){
                boolean paied = rs.getInt("paied") == 1;
                monthBills.add(new MonthBill(rs.getFloat("amount"), rs.getTimestamp("time"),paied,"property"));
            }
            return monthBills;
        });
        List<MonthBill> monthBillsProperty = (List<MonthBill>)o;
        String selectParking = "SELECT * FROM park_fee WHERE household_ID= ? and time between ? and ?";
        Object b = MysqlConnection.select(selectParking, rs->{
            List<MonthBill> monthBills = new ArrayList<>();
            while (rs.next()){
                boolean paied = rs.getInt("paied") == 1;
                monthBills.add(new MonthBill(rs.getFloat("amount"),rs.getTimestamp("time"),paied,"property"));
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
