package entity;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class UserRepairManager implements EntityManager<UserRepair>{
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    private UserRepairManager(){
    }

    @Override
    public boolean insert(UserRepair entity) {
        return false;
    }

    @Override
    public boolean update(UserRepair entity) {
        return false;
    }

    @Override
    public boolean delete(UserRepair entity) {
        return false;
    }

    private static class SingletonFactory{
        private static UserRepairManager instance = new UserRepairManager();
    }

    public static UserRepairManager getInstance(){
        return UserRepairManager.SingletonFactory.instance;
    }

    public List<UserRepair> get(Integer beginYear, Integer beginMonth, Integer endYear, Integer endMonth){
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

    public List<UserRepair> get(){
        String selectSql = "SELECT household_ID, count(*) as count, count(amount) as amounts FROM household natural join repair natural join repair_fee group by household_ID";
        Object o = MysqlConnection.select(selectSql, rs->{
            List<UserRepair> userRepairs = new ArrayList<>();
            while (rs.next()){
                userRepairs.add(new UserRepair(rs.getInt("household_ID"), rs.getInt("count"), rs.getInt("amounts")));
            }
            return userRepairs;
        });
        return (List<UserRepair>)o;
    }
}
