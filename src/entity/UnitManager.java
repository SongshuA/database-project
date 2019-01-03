package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class UnitManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public UnitManager(){
    }

    private static class SingletonFactory{
        private static UnitManager instance = new UnitManager();
    }

    public static UnitManager getInstance(){
        return UnitManager.SingletonFactory.instance;
    }

    public List<Unit> get(){
        String selectSql = "SELECT * FROM unit";
        List<Unit> result = new ArrayList<>();
        try{
            ResultSet rs = MysqlConnection.select(selectSql);
            while (rs.next()){
                result.add(new Unit(rs.getInt("ID"), rs.getInt("house_ID"),rs.getString("community_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean insert(Unit unit){
        String insertSQL = "INSERT INTO unit (ID, house_ID, community_name) values(?,?,?)";
        Object[] params = new Object[3];
        params[0] = unit.getId();
        params[1] = unit.getHouseId();
        params[2] = unit.getCommunityName();
        MysqlConnection.executeUpdate(insertSQL, params);
        return true;
    }

    public boolean update(Unit unit){
        Integer id = unit.getId();
        Integer house_id = unit.getHouseId();
        String community_name = unit.getCommunityName();
        String updateSql = "UPDATE unit set ";
        if(null != house_id) updateSql += "house_id='" + house_id +"' ,";
        if(null != community_name) updateSql += "community_name='" + community_name +"' ,";
        updateSql = updateSql.substring(0, updateSql.length() - 1) + "WHERE id='" + id + "'";
        MysqlConnection.executeUpdate(updateSql);
        return true;
    }

    public boolean delete(Unit unit){
        Integer id = unit.getId();
        String deteleSql = "DELETE FROM unit WHERE id='" + id + "'";
        MysqlConnection.executeUpdate(deteleSql);
        return true;
    }
}
