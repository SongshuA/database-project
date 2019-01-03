package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class ComplaintManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public ComplaintManager(){
    }

    private static class SingletonFactory{
        private static ComplaintManager instance = new ComplaintManager();
    }

    public static ComplaintManager getInstance(){
        return ComplaintManager.SingletonFactory.instance;
    }

    public List<Complaint> get(){
        List<Complaint> result = new ArrayList<>();
        String selectSql = "SELECT * FROM complaint";
        try{
            ResultSet rs = MysqlConnection.select(selectSql);
            while (rs.next()){
                result.add(new Complaint(rs.getInt("ID"), rs.getString("type"), rs.getTimestamp("time"),rs.getString("description"),rs.getInt("household_id"),rs.getTimestamp("schedule"),rs.getString("outcome"),rs.getTimestamp("outcome_time")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }

    public boolean insert(Complaint complaint){
        String insertSql = "INSERT INTO complaint (ID, type, time, description, household_id, schedule, outcome, outcome_time) values(?,?,?,?,?,?,?,?)";
        Object[] params = new Object[8];
        params[0] = complaint.getId();
        params[1] = complaint.getType();
        params[2] = complaint.getTime();
        params[3] = complaint.getDescription();
        params[4] = complaint.getHouseholdId();
        params[5] = complaint.getSchedule();
        params[6] = complaint.getOutcome();
        params[7] = complaint.getOutcomeTime();
        MysqlConnection.executeUpdate(insertSql, params);
        return true;
    }

    public boolean update(Complaint complaint){
        String updateSql = "UPDATE complaint set ";
        Integer ID = complaint.getId();
        String type = complaint.getType();
        Timestamp time = complaint.getTime();
        String description = complaint.getDescription();
        Integer householdId = complaint.getHouseholdId();
        Timestamp schedule = complaint.getSchedule();
        String outcome = complaint.getOutcome();
        Timestamp outcomeTime = complaint.getOutcomeTime();
        if(null != type) updateSql += "type='" + type + "' ,";
        if(null != time) updateSql += "time='" + time + "' ,";
        if(null != description) updateSql += "description='" + description +"' ,";
        if(null != householdId) updateSql += "household_id='" + householdId + "' ,";
        if(null != schedule) updateSql += "schedule='" + schedule +"' ,";
        if(null != outcome) updateSql += "outcome='" + schedule +"' ,";
        if(null != outcomeTime) updateSql += "outcome_time'" + outcomeTime +"' ,";
        updateSql += " WHERE ID = '" + ID +"'";
        MysqlConnection.executeUpdate(updateSql);
        return true;
    }
}
