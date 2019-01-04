package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.MysqlConnection;

public class BalanceManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public BalanceManager(){
    }

    private static class SingletonFactory{
        private static BalanceManager instance = new BalanceManager();
    }

    public static BalanceManager getInstance(){
        return BalanceManager.SingletonFactory.instance;
    }

    public List<Balance> get(Timestamp begin, Timestamp end){
//        String selectParkFee = "SELECT * FROM park_fee WHERE time between '" + begin + "' and '" + end + "'";
        String selectParkFee = "SELECT * FROM park_fee WHERE time between ? and ?";
        Object[] params = new Object[2];
        params[0] = begin;
        params[1] = end;
        Object o = MysqlConnection.select(selectParkFee, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "parking",rs.getTimestamp("time")));
            }
            return balances;
        }, params);
        List<Balance> balancesParking = (List<Balance>)o;
        String selectProperty = "SELECT * FROM property_fee WHERE time between ? and ?";
        Object b = MysqlConnection.select(selectProperty, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "property", rs.getTimestamp("time")));
            }
            return balances;
        }, params);
        List<Balance> balancesProperty = (List<Balance>)b;
        String selectRepair = "SELECT * FROM repair_fee WHERE time between ? and ?";
        Object j = MysqlConnection.select(selectRepair, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "repair", rs.getTimestamp("time")));
            }
            return balances;
        },params);
        List<Balance> balancesRepair = (List<Balance>)j;
        String selectOther = "SELECT * FROM other_fee WHERE time between ? and ?";
        Object e = MysqlConnection.select(selectOther, rs->{
            List<Balance> balances = new ArrayList<>();
            while (rs.next()){
                balances.add(new Balance(rs.getFloat("amount"), "other", rs.getTimestamp("time")));
            }
            return balances;
        }, params);
        List<Balance> balancesOther = (List<Balance>)j;
        List<Balance> balances = new ArrayList<>();
        if(null != balancesOther)balances.addAll(balancesOther);
        if(null != balancesParking) balances.addAll(balancesParking);
        if(null != balancesProperty) balances.addAll(balancesProperty);
        if(null != balancesRepair) balances.addAll(balancesRepair);
        return balances;
    }
}
