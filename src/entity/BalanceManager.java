package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.MysqlConnection;
import util.DateCreate;

public class BalanceManager implements EntityManager<Balance>{
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    private BalanceManager(){}

    public List<Balance> get(Integer beginYear, Integer beginMonth, Integer endYear, Integer endMonth){
        List<Timestamp> timestamps = DateCreate.create(beginYear,beginMonth,endYear,endMonth);
        String selectParkFee = "SELECT * FROM park_fee WHERE time between ? and ?";
        Object[] params = new Object[2];
        params[0] = timestamps.get(0);
        params[1] = timestamps.get(1);
        Object o = MysqlConnection.select(selectParkFee, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "停车收入",rs.getTimestamp("time"),rs.getString("description")));
            }
            return balances;
        }, params);
        List<Balance> balancesParking = (List<Balance>)o;
        String selectProperty = "SELECT * FROM property_fee WHERE time between ? and ?";
        Object b = MysqlConnection.select(selectProperty, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "物业收入", rs.getTimestamp("time"),rs.getString("description")));
            }
            return balances;
        }, params);
        List<Balance> balancesProperty = (List<Balance>)b;
        String selectRepair = "SELECT * FROM repair_fee WHERE time between ? and ?";
        Object j = MysqlConnection.select(selectRepair, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "维修支出", rs.getTimestamp("time"), rs.getString("description")));
            }
            return balances;
        },params);
        List<Balance> balancesRepair = (List<Balance>)j;
        String selectOther = "SELECT * FROM other_fee WHERE time between ? and ?";
        Object e = MysqlConnection.select(selectOther, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "其他收入", rs.getTimestamp("time"), rs.getString("description")));
            }
            return balances;
        }, params);
        List<Balance> balancesOther = (List<Balance>)e;
        List<Balance> balances = new ArrayList<>();
        if(null != balancesOther)balances.addAll(balancesOther);
        if(null != balancesParking) balances.addAll(balancesParking);
        if(null != balancesProperty) balances.addAll(balancesProperty);
        if(null != balancesRepair) balances.addAll(balancesRepair);
        return balances;
    }

    @Override
    public boolean insert(Balance entity) {
        return false;
    }

    @Override
    public boolean update(Balance entity) {
        return false;
    }

    @Override
    public boolean delete(Balance entity) {
        return false;
    }

    private static class SingletonFactory{
        private static BalanceManager instance = new BalanceManager();
    }

    public static BalanceManager getInstance(){
        return BalanceManager.SingletonFactory.instance;
    }

    @Override
    public List<Balance> get(){
        String selectParkFee = "SELECT * FROM park_fee";
        Object o = MysqlConnection.select(selectParkFee, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "停车收入",rs.getTimestamp("time"),rs.getString("description")));
            }
            return balances;
        });
        List<Balance> balancesParking = (List<Balance>)o;
        String selectProperty = "SELECT * FROM property_fee";
        Object b = MysqlConnection.select(selectProperty, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "物业收入", rs.getTimestamp("time"),rs.getString("description")));
            }
            return balances;
        });
        List<Balance> balancesProperty = (List<Balance>)b;
        String selectRepair = "SELECT * FROM repair_fee";
        Object j = MysqlConnection.select(selectRepair, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "维修支出", rs.getTimestamp("time"),rs.getString("description")));
            }
            return balances;
        });
        List<Balance> balancesRepair = (List<Balance>)j;
        String selectOther = "SELECT * FROM other_fee";
        Object e = MysqlConnection.select(selectOther, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "其他收入", rs.getTimestamp("time"),rs.getString("description")));
            }
            return balances;
        });
        List<Balance> balancesOther = (List<Balance>)e;
        List<Balance> balances = new ArrayList<>();
        if(null != balancesOther)balances.addAll(balancesOther);
        if(null != balancesParking) balances.addAll(balancesParking);
        if(null != balancesProperty) balances.addAll(balancesProperty);
        if(null != balancesRepair) balances.addAll(balancesRepair);
        return balances;
   }
}
