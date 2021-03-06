package entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.MysqlConnection;

public class ResidentManager implements EntityManager<Resident> {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public ResidentManager(){
    }

    private static class SingletonFactory{
        private static ResidentManager instance = new ResidentManager();
    }

    public static ResidentManager getInstance(){
        return ResidentManager.SingletonFactory.instance;
    }

    @Override
    public List<Resident> get() {
        String selectSql = "SELECT * FROM resident";
        Object o = MysqlConnection.select(selectSql, rs->{
            List<Resident> residents = new ArrayList<>();
            while (rs.next()){
                residents.add(new Resident(rs.getInt("resident_ID"),rs.getString("name"),rs.getString("contact"),rs.getInt("household_ID")));
            }
            return residents;
        });
        return (List<Resident>)o;
    }

    @Override
    public boolean insert(Resident entity) {
        try {
            String insertSql = "INSERT INTO resident (name, contact, household_ID) values(?,?,?)";
            Object[] params = new Object[3];
            params[0] = entity.getName();
            params[1] = entity.getContact();
            params[2] = entity.getHouseholdId();
            MysqlConnection.executeUpdate(insertSql, params);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Resident entity) {
        try {
            Integer residentId = entity.getResidentId();
            String name = entity.getName();
            String contact = entity.getContact();
            Integer householdId = entity.getHouseholdId();
            String updateSql = "UPDATE resident set ";
            if (name != null) updateSql += " name='" + name + "' ,";
            if (contact != null) updateSql += " contact='" + contact + "' ,";
            if (householdId != null) updateSql += " household_ID='" + householdId + "' ,";
            updateSql = updateSql.substring(0, updateSql.length() - 1) + " WHERE resident_ID='" + residentId + "'";
            MysqlConnection.executeUpdate(updateSql);
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    @Override
    public boolean delete(Resident entity) {
        try {
            Integer residentId = entity.getResidentId();
            String deleteSql = "DELETE FROM resident WHERE resident_ID=?";
            Object[] params = new Object[1];
            params[0] = residentId;
            MysqlConnection.executeUpdate(deleteSql, params);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
