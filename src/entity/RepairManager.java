package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.MysqlConnection;
import util.DateCreate;

public class RepairManager implements EntityManager<Repair> {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public RepairManager(){
    }

    private static class SingletonFactory{
        private static RepairManager instance = new RepairManager();
    }

    public static RepairManager getInstance(){
        return RepairManager.SingletonFactory.instance;
    }

    @Override
    public List<Repair> get() {
        String selectSql = "SELECT * FROM repair";
        Object o = MysqlConnection.select(selectSql, rs->{
            List<Repair> repairs = new ArrayList<>();
            while (rs.next()){
                repairs.add(new Repair(rs.getInt("repair_ID"),rs.getString("operator"),rs.getInt("device_ID"),rs.getTimestamp("time"),rs.getTimestamp("schedule"),rs.getString("description"),rs.getString("outcome"),rs.getTimestamp("outcome_time"),rs.getInt("household_ID"),rs.getInt("repair_fee_ID")));
            }
            return repairs;
        });
        return (List<Repair>)o;
    }
    public List<Repair> get(Integer beginYear, Integer beginMonth,Integer endYear,Integer endMonth){
        List<Timestamp> timestamps = DateCreate.create(beginYear, beginMonth,endYear,endMonth);
        String selectSql = "SELECT * FROM repair WHERE time between ? and ?";
        Object[] params = new Object[2];
        params[0] = timestamps.get(0);
        params[1] = timestamps.get(1);
        Object o = MysqlConnection.select(selectSql, rs->{
            List<Repair> repairs = new ArrayList<>();
            while (rs.next()){
                repairs.add(new Repair(rs.getInt("repair_ID"),rs.getString("operator"),rs.getInt("device_ID"),rs.getTimestamp("time"),rs.getTimestamp("schedule"),rs.getString("description"),rs.getString("outcome"),rs.getTimestamp("outcome_time"),rs.getInt("household_ID"),rs.getInt("repair_fee_ID")));
            }
            return repairs;
        },params);
        return (List<Repair>)o;
    }

    @Override
    public boolean insert(Repair entity) {
        try {
            String insertSql = "INSERT INTO repair (operator, device_ID, time, schedule, description, outcome,outcome_time, household_ID, repair_fee_ID) values(?,?,?,?,?,?,?,?,?)";
            Object[] params = new Object[9];
            params[0] = entity.getOperator();
            params[1] = entity.getDevice_ID();
            params[2] = entity.getTime();
            params[3] = entity.getSchedule();
            params[4] = entity.getDescription();
            params[5] = entity.getOutcome();
            params[6] = entity.getOutcomeTime();
            params[7] = entity.getHouseholdId();
            params[8] = entity.getRepairFeeId();
            MysqlConnection.executeUpdate(insertSql, params);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Repair entity) {
        try {
            Integer repairId = entity.getPreairId();
            String operator = entity.getOperator();
            Integer deviceId = entity.getDevice_ID();
            Timestamp time = entity.getTime();
            Timestamp schedule = entity.getSchedule();
            String description = entity.getDescription();
            String outcome = entity.getOutcome();
            Timestamp outcomeTime = entity.getOutcomeTime();
            Integer householdId = entity.getHouseholdId();
            Integer repairFeeId = entity.getRepairFeeId();
            String updateSql = "UPDATE reapir set ";
            if (operator != null) updateSql += " operator='" + operator + "' ,";
            if (deviceId != null) updateSql += " device_ID='" + deviceId + "' ,";
            if (time != null) updateSql += " time='" + time + "', ";
            if (schedule != null) updateSql += " schedule='" + schedule + "' ,";
            if (description != null) updateSql += " description='" + description + "' ,";
            if (outcome != null) updateSql += " outcome='" + outcome + "' ,";
            if (outcomeTime != null) updateSql += " outcome_time='" + outcomeTime + "' ,";
            if (householdId != null) updateSql += " household_ID='" + householdId + "' ,";
            if (repairFeeId != null) updateSql += " repair_fee_ID='" + repairFeeId + "' ,";
            updateSql = updateSql.substring(0, updateSql.length() - 1) + "WHERE repair_ID='" + repairId + "'";
            MysqlConnection.executeUpdate(updateSql);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Repair entity) {
        try {
            String deleteSql = "DELETE FROM repair WHERE repair_ID=?";
            Object[] params = new Object[1];
            params[0] = entity.getPreairId();
            MysqlConnection.executeUpdate(deleteSql, params);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
