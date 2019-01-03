package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class RepairManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public RepairManager(){
    }

    private static class SingletonFactory{
        private static RepairManager instance = new RepairManager();
    }

    public static RepairManager getInstance(){
        return RepairManager.SingletonFactory.instance;
    }

    public List<Repair> get(){
        String selectSql  = "SELECT * FROM repair";
        List<Repair> result = new ArrayList<>();
        try{
            ResultSet rs = MysqlConnection.select(selectSql);
            while (rs.next()){
                result.add(new Repair(rs.getInt("ID"), rs.getString("operator"),rs.getInt("device_id"),rs.getTimestamp("time"),rs.getTimestamp("schedule"),rs.getString("description"),rs.getString("outcome"),rs.getTimestamp("outcome_time"),rs.getInt("household_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean insert(Repair repair){
        String insertSql = "INSERT INTO repair values(?,?,?,?,?,?,?,?,?)";
        Object[] params = new Object[9];
        params[0] = repair.getId();
        params[1] = repair.getOperator();
        params[2] = repair.getDeviceId();
        params[3] = repair.getTime();
        params[4] = repair.getSchedule();
        params[5] = repair.getDescription();
        params[6] = repair.getOutcome();
        params[7] = repair.getOutcomeTime();
        params[8] = repair.getHouseholdId();
        MysqlConnection.executeUpdate(insertSql);
        return true;
    }

    public boolean update(Repair repair){
        Integer id = repair.getId();
        String operator = repair.getOperator();
        Integer device_id = repair.getDeviceId();
        Timestamp time = repair.getTime();
        String description = repair.getDescription();
        String outcome = repair.getOutcome();
        Timestamp outcomeTime = repair.getOutcomeTime();
        Integer householdId = repair.getHouseholdId();
        String updateSql = "UPDATE repair set ";
        if(null != operator) updateSql += " operator='" + operator + "' ,";
        if(null != device_id) updateSql += " device_id='" + device_id +"' ,";
        if(null != time) updateSql += " time='" + time + "' ,";
        if(null != description) updateSql += " description='" + description + "' ,";
        if(null != outcome) updateSql += " outcome='" + outcome + "' ,";
        if(null != outcomeTime) updateSql += " outcome_time='" + outcomeTime + "' ,";
        if(null != householdId) updateSql += " household_id='" + householdId + "' ,";
        updateSql = updateSql.substring(0, updateSql.length() - 1) + " WHERE ID='" +id;
        MysqlConnection.executeUpdate(updateSql);
        return true;
    }

    public boolean delete(Repair repair){
        Integer id = repair.getId();
        String deleteSql = "DELETE FROM repair WHERE ID=?";
        Object params = new Object();
        params = id;
        MysqlConnection.executeUpdate(deleteSql, params);
        return true;
    }


}
