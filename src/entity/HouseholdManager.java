package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

import javax.jws.Oneway;

public class HouseholdManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public HouseholdManager(){
    }

    private static class SingletonFactory{
        private static HouseholdManager instance = new HouseholdManager();
    }

    public static HouseholdManager getInstance(){
        return HouseholdManager.SingletonFactory.instance;
    }

    public List<Household> get(){
        String selectSql = "SELECT * FROM household";
        List<Household> result = new ArrayList<>();
        try{
            ResultSet rs = MysqlConnection.select(selectSql);
            while (rs.next()){
                result.add(new Household(rs.getInt("ID"), rs.getInt("unit_ID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean insert(Household household){
        String insertSql = "INSERT INTO household (ID, unit_ID) values(?,?)";
        Integer id = household.getId();
        Integer unitId = household.getUnitId();
        Object[] params = new Object[2];
        params[0] = id;
        params[1] = unitId;
        MysqlConnection.executeUpdate(insertSql, params);
        return true;
    }

    public boolean update(Household household){
        Integer id = household.getId();
        Integer unitId = household.getUnitId();
        String updateSql = "UPDATE household set ";
        if(null != unitId) updateSql += "unit_ID='" + unitId + "' ,";
        updateSql = updateSql.substring(0, updateSql.length() - 1) + " WHERE ID='" + id + "'";
        MysqlConnection.executeUpdate(updateSql);
        return true;
    }

    public boolean delete(Household household){
        int id = household.getId();
        String delete  = "DELETE FROM household WHERE id='" + id + "'";
        MysqlConnection.executeUpdate(delete);
        return true;
    }
}
