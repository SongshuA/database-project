package entity;

import util.MysqlConnection;

import java.util.ArrayList;
import java.util.List;

public class FreeHouseManager implements EntityManager<FreeHouse> {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public FreeHouseManager(){
    }

    private static class SingletonFactory{
        private static FreeHouseManager instance = new FreeHouseManager();
    }

    public static FreeHouseManager getInstance(){
        return FreeHouseManager.SingletonFactory.instance;
    }

    public List<FreeHouse> get(){
        String selectSql = "SELECT * FROM house natural join community WHERE house.house_ID not in (SELECT distinct house_ID FROM household)";
        Object o = MysqlConnection.select(selectSql, rs->{
            List<FreeHouse> freeHouses = new ArrayList<>();
            while (rs.next()){
                freeHouses.add(new FreeHouse(rs.getInt("house_ID"),rs.getInt("unit_ID"),rs.getString("community_name"),rs.getInt("size")));
            }
            return freeHouses;
        });
        return (List<FreeHouse>)o;
    }

    @Override
    public boolean insert(FreeHouse entity) {
        String insertSql = "INSERT INTO house (unit_ID, community_name, size) values(?,?,?)";
        Object[] params = new Object[3];
        params[0] = entity.getUnit_ID();
        params[1] = entity.getCommunity_name();
        params[2] = entity.getSize();
        MysqlConnection.executeUpdate(insertSql,params);
        return true;
    }

    @Override
    public boolean update(FreeHouse entity) {
        Integer house_ID = entity.getHouse_ID();
        Integer unit_ID = entity.getUnit_ID();
        String community_name = entity.getCommunity_name();
        Integer size = entity.getSize();
        List<Object> params = new ArrayList<>();
        String updateSql = "UPDATE house set ";
        if(unit_ID != null) {
            updateSql += " unit_ID='" + unit_ID + "' ,";
//            params.add(unit_ID);
        }
        if(community_name != null){
            updateSql +=" community_name='" + community_name + "' ,";
//            params.add(community_name);
        }
        if(size != null){
            updateSql += " size='" + size + "' ,";
//            params.add(size);
        }
        updateSql = updateSql.substring(0, updateSql.length() - 1) + " WHERE house_ID='" + house_ID + "'";
        params.add(house_ID);
        MysqlConnection.executeUpdate(updateSql,params);
        return true;
    }

    @Override
    public boolean delete(FreeHouse entity) {
        String deleteSql = "DELETE FROM house WHERE house_ID=?";
        Object[] params = new Object[1];
        params[0] = entity.getHouse_ID();
        MysqlConnection.executeUpdate(deleteSql,params);
        return true;
    }

    public List<FreeHouse> get(String community_name){
        if(community_name == null) return get();
        String selectSql = "SELECT * FROM house natural join community WHERE community.community_name = ? and house.house_ID not in (SELECT distinct house_ID FROM household)";
        Object[] params = new Object[1];
        params[0] = community_name;
        Object o = MysqlConnection.select(selectSql, rs->{
            List<FreeHouse> freeHouses = new ArrayList<>();
            while (rs.next()){
                freeHouses.add(new FreeHouse(rs.getInt("house_ID"),rs.getInt("unit_ID"),rs.getString("community_name"),rs.getInt("size")));
            }
            return freeHouses;
        }, params);
        return (List<FreeHouse>)o;
    }


}
