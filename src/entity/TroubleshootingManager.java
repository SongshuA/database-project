package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.DateCreate;
import util.MysqlConnection;

public class TroubleshootingManager implements EntityManager<Troubleshooting> {
    @Override
    public List<Troubleshooting> get() {
        String selectSql = "SELECT * FROM troubleshooting";
        Object b = MysqlConnection.select(selectSql,rs->{
            List<Troubleshooting> troubleshootings = new ArrayList<>();
            while (rs.next()){
                troubleshootings.add(new Troubleshooting(rs.getInt("troubleshooting_ID"),rs.getTimestamp("time"),rs.getString("operator"),rs.getString("description"),rs.getInt("repair_fee_ID"),rs.getInt("device_ID")));
            }
            return troubleshootings;
        });
        return (List<Troubleshooting>)b;
    }

    public List<Troubleshooting> get(Integer beginYear, Integer beginMonth,Integer endYear,Integer endMonth) {
        List<Timestamp> timestamps = DateCreate.create(beginYear, beginMonth,endYear,endMonth);
        String selectSql = "SELECT * FROM troubleshooting WHERE time between ? and ?";
        Object[] params = new Object[2];
        params[0] = timestamps.get(0);
        params[1] = timestamps.get(1);
        Object b = MysqlConnection.select(selectSql,rs->{
            List<Troubleshooting> troubleshootings = new ArrayList<>();
            while (rs.next()){
                troubleshootings.add(new Troubleshooting(rs.getInt("troubleshooting_ID"),rs.getTimestamp("time"),rs.getString("operator"),rs.getString("description"),rs.getInt("repair_fee_ID"),rs.getInt("device_ID")));
            }
            return troubleshootings;
        },params);
        return (List<Troubleshooting>)b;
    }

    @Override
    public boolean insert(Troubleshooting entity) {
        String insertSql = "INSERT INTO troubleshooting (time, operator, description, repair_fee_ID, device_ID) values(?,?,?,?,?)";
        Object[] params = new Object[5];
        params[0] = entity.getTime();
        params[1] = entity.getOperator();
        params[2] = entity.getDescription();
        params[3] = entity.getRepairFeeId();
        params[4] = entity.getDeviceId();
        MysqlConnection.executeUpdate(insertSql,params);
        return true;
    }

    @Override
    public boolean update(Troubleshooting entity) {
        Integer troubleshooting_ID = entity.getTrobleshootingId();
        Timestamp timestamp = entity.getTime();
        String operator = entity.getOperator();
        String description = entity.getDescription();
        Integer repair_fee_ID = entity.getRepairFeeId();
        Integer device_ID = entity.getDeviceId();
        String updateSql = "UPDATE troubleshooting set ";
        if(timestamp != null) updateSql += " time='" + timestamp + "' ,";
        if(operator != null) updateSql += " operator='" + operator + "' ,";
        if(description != null) updateSql += "description='" + description + "' ,";
        if(repair_fee_ID != null) updateSql += " repair_fee_ID='" + repair_fee_ID + "' ,";
        if(device_ID != null) updateSql += " device_ID='" + device_ID + "' ,";
        updateSql = updateSql.substring(0, updateSql.length() - 1) + " WHERE troubleshooting_ID='" + troubleshooting_ID + "'";
        MysqlConnection.executeUpdate(updateSql);
        return true;
    }

    @Override
    public boolean delete(Troubleshooting entity) {
        String deleteSql = "DELETE FROM troubleshooting WHERE troubleshooting_ID = ?";
        Object[] params = new Object[1];
        params[0] = entity.getTrobleshootingId();
        MysqlConnection.executeUpdate(deleteSql,params);
        return true;
    }
}
