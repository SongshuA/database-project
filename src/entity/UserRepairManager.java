package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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

    public List<UserRepair> get(Timestamp begin, Timestamp end){
        String selectSql = "SELECT household_ID, count(*) as count, count(amount) as amounts FROM household natural join repair natural join repair_fee WHERE time between ? and ? group by household_ID";
        Object[] params = new Object[2];
        params[0] = begin;
        params[1] = end;
        Object o = MysqlConnection.select(selectSql, rs->{
           List<UserRepair> userRepairs = new ArrayList<>();
           while (rs.next()){
               userRepairs.add(new UserRepair(rs.getInt("household_ID"), rs.getInt("count"), rs.getInt("amounts")));
           }
           return userRepairs;
        }, params);
        return (List<UserRepair>)o;
    }
}
