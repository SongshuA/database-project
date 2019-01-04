package entity;

import java.util.ArrayList;
import java.util.List;

import util.MysqlConnection;

public class CommunityManager implements EntityManager<Community> {

    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    private CommunityManager() {
    }

    private static class SingletonFactory {
        private static CommunityManager instance = new CommunityManager();
    }

    public static CommunityManager getInstance() {
        return SingletonFactory.instance;
    }


    @Override
    public List<Community> get() {
        //在这里利用JDBC获取内容
        String querySql = "SELECT * FROM community";
        Object o = MysqlConnection.select(querySql, rs -> {
            List<Community> result = new ArrayList<>();
            while (rs.next()) {
                Community community = new Community(rs.getString("community_name"), rs.getFloat("property_fee"), rs.getFloat("rent_fee"), rs.getFloat("purchase_fee"));
                result.add(community);
            }
            return result;
        });
        return (List<Community>) o;
    }

    @Override
    public boolean insert(Community entity) {
        try {
            //插入对象 entity
            String insertSql = "INSERT INTO community (community_name, property_fee, rent_fee, purchase_fee) values (?, ?, ?, ?)";
            Object[] params = new Object[4];
            params[0] = entity.getName();
            params[1] = entity.getPropertyFee();
            params[2] = entity.getRentFee();
            params[3] = entity.getPurchaseFee();
            MysqlConnection.executeUpdate(insertSql, params);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(Community entity) {
        try {
            String name = entity.getName();
            Float property_fee = entity.getPropertyFee();
            Float rent_fee = entity.getRentFee();
            Float purchase_fee = entity.getPurchaseFee();
            Object[] params = new Object[3];
            // 查找名称为 name 的小区对象并修改
            String updateSql = "UPDATE community SET";
            if (null != property_fee) updateSql += " property_fee='" + property_fee + "' ,";
            if (null != rent_fee) updateSql += " rent_fee='" + rent_fee + "' ,";
            if (null != purchase_fee) updateSql += " purchase_fee='" + purchase_fee + "' ,";
            updateSql = updateSql.substring(0, updateSql.length() - 1) + "WHERE community_name =" + "'" + name + "'";
            MysqlConnection.executeUpdate(updateSql);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean delete(Community entity) {
        try {
            String name = entity.getName();
            // 查找名称为 name 的小区对象并删除
            String deleteSql = "DELETE FROM community WHERE community_name= ?";
            Object[] params = new Object[1];
            params[0] = name;
            MysqlConnection.executeUpdate(deleteSql, params);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
