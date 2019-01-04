package entity;

import util.DateCreate;
import util.MysqlConnection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RepairFeeManager implements EntityManager<RepairFee>{
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public RepairFeeManager(){
    }

    private static class SingletonFactory{
        private static RepairFeeManager instance = new RepairFeeManager();
    }

    public static RepairFeeManager getInstance(){
        return RepairFeeManager.SingletonFactory.instance;
    }

    @Override
    public List<RepairFee> get() {
        String selectSql = "SELECT * FROM repair_fee";
        Object b = MysqlConnection.select(selectSql, rs->{
            List<RepairFee> repairFees = new ArrayList<>();
            while (rs.next()){
                repairFees.add(new RepairFee(rs.getInt("repair_fee_ID"),rs.getDouble("amount"),rs.getTimestamp("time"),rs.getInt("paied"),rs.getString("description")));
            }
            return repairFees;
        });
        return (List<RepairFee>)b;
    }
    public List<RepairFee> get(Integer beginYear, Integer beginMonth,Integer endYear,Integer endMonth) {
        List<Timestamp> timestamps = DateCreate.create(beginYear, beginMonth,endYear,endMonth);
        String selectSql = "SELECT * FROM repair_fee WHERE time between ? and ?";
        Object[] params = new Object[2];
        params[0] = timestamps.get(0);
        params[1] = timestamps.get(1);
        Object b = MysqlConnection.select(selectSql, rs->{
            List<RepairFee> repairFees = new ArrayList<>();
            while (rs.next()){
                repairFees.add(new RepairFee(rs.getInt("repair_fee_ID"),rs.getDouble("amount"),rs.getTimestamp("time"),rs.getInt("paied"),rs.getString("description")));
            }
            return repairFees;
        },params);
        return (List<RepairFee>)b;
    }

    @Override
    public boolean insert(RepairFee entity) {
        String insertSql = "INSERT INTO repair_fee_ID (amount, time, paied, description) values(?,?,?,?)";
        Object[] params = new Object[4];
        params[0] = entity.getAmount();
        params[1] = entity.getTime();
        params[2] = entity.getPaied();
        params[3] = entity.getDescription();
        MysqlConnection.executeUpdate(insertSql,params);
        return true;
    }

    @Override
    public boolean update(RepairFee entity) {
        Integer repairFeeId = entity.getRepairFeeId();
        Double amount  = entity.getAmount();
        Timestamp time = entity.getTime();
        Integer paied = entity.getPaied();
        String description = entity.getDescription();
        String updateSql = "UPDATE repair_fee set";
        if(repairFeeId != null) updateSql += "repair_fee_ID='" + repairFeeId +"' ,";
        if(amount != null)  updateSql += " amount='" + amount + "' ,";
        if(time !=null)  updateSql +=" time='" + time + "' ,";
        if(paied !=null) updateSql +=" paied='" + paied + "' ,";
        if(description != null) updateSql += " description='" + description + "' ,";
        updateSql = updateSql.substring(0, updateSql.length() - 1) + "WHERE repair_fee_ID='" + repairFeeId + "'";
        MysqlConnection.executeUpdate(updateSql);
        return true;
    }

    @Override
    public boolean delete(RepairFee entity) {
        String deleteSql = "DELETE FROM repair_fee WHERE repair_fee_ID=?";
        Object[] params = new Object[1];
        params[0] = entity.getRepairFeeId();
        MysqlConnection.executeUpdate(deleteSql,params);
        return true;
    }
}
