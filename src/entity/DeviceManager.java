package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class DeviceManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public DeviceManager(){
    }

    private static class SingletonFactory{
        private static DeviceManager instance = new DeviceManager();
    }

    public static DeviceManager getInstance(){
        return DeviceManager.SingletonFactory.instance;
    }

    public List<Device> get(){
        String selectSql = "SELECT * FROM device";
        List<Device> result = new ArrayList<>();
        try {
            ResultSet rs = MysqlConnection.select(selectSql);
            while (rs.next()){
                result.add(new Device(rs.getInt("ID"),rs.getString("type"), rs.getString("community_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean insert(Device device){
        String insertSql = "INSERT INTO device(ID, type, community_name) values(?,?,?)";
        Object[] params  = new Object[3];
        params[0] = device.getId();
        params[1] = device.getType();
        params[2] = device.getCommunityName();
        MysqlConnection.executeUpdate(insertSql, params);
        return true;
    }

    public boolean update(Device device){
        String updateSql = "UPDATE device set ";
        Integer id = device.getId();
        String type = device.getType();
        String communityName = device.getCommunityName();
        if(null != type) updateSql += " type='" + type + "' ,";
        if(null != communityName) updateSql += " community_name=" + communityName + "' ,";
        updateSql = updateSql.substring(0, updateSql.length() - 1) + " WHERE ID='" + id +"'";
        MysqlConnection.executeUpdate(updateSql);
        return true;
    }

    public boolean delete(Device device){
        Integer id = device.getId();
        String deleteSql = "DELETE FROM device WHERE id='" + id +"'";
        MysqlConnection.executeUpdate(deleteSql);
        return true;
    }
}
