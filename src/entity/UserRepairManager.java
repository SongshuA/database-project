package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.DateCreate;
import util.MysqlConnection;

public class UserRepairManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public UserRepairManager(){
    }

    private static class SingletonFactory{
        private static UserRepairManager instance = new UserRepairManager();
    }

    public static UserRepairManager getInstance(){
        return UserRepairManager.SingletonFactory.instance;
    }

    public List<UserRepair> get(Integer beginYear, Integer beginMonth, Integer endYear, Integer endMonth){
        List<Timestamp> timestamps = DateCreate.create(beginYear,beginMonth,endYear,endMonth);
        String selectSql = "SELECT household_ID, count(*) as count, sum(amount) as amounts FROM household natural join `repair` join repair_fee on `repair`.repair_fee_ID=repair_fee.repair_fee_ID WHERE `repair`.time between ? and ? group by household_ID";
        Object[] params = new Object[2];
        params[0] = timestamps.get(0);
        params[1] = timestamps.get(1);
        Object o = MysqlConnection.select(selectSql, rs->{
           List<UserRepair> userRepairs = new ArrayList<>();
           while (rs.next()){
               userRepairs.add(new UserRepair(rs.getInt("household_ID"), rs.getInt("count"), rs.getDouble("amounts")));
           }
           return userRepairs;
        }, params);
        return (List<UserRepair>)o;
    }

    public List<UserRepair> get(){
        String selectSql = "SELECT household_ID, count(*) as count, sum(amount) as amounts FROM household natural join `repair` join repair_fee on `repair`.repair_fee_ID=repair_fee.repair_fee_ID group by household_ID";
        Object o = MysqlConnection.select(selectSql, rs->{
            List<UserRepair> userRepairs = new ArrayList<>();
            while (rs.next()){
                userRepairs.add(new UserRepair(rs.getInt("household_ID"), rs.getInt("count"), rs.getDouble("amounts")));
            }
            return userRepairs;
        });
        return (List<UserRepair>)o;
    }
}
