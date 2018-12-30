package entity;

import java.util.ArrayList;
import java.util.List;

public class CommunityManager implements EntityManager<Community>{

    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    private CommunityManager(){}

    private static class SingletonFactory{
        private static CommunityManager instance = new CommunityManager();
    }

    public static CommunityManager getInstance(){
        return SingletonFactory.instance;
    }


    @Override
    public List<Community> get() {
        //在这里利用JDBC获取内容
        List<Community> result = new ArrayList<>();
        result.add(new Community( "知乎社区", 10.0f,10.0f, 10.0f));
        result.add(new Community( "另一个社区", 20.0f,20.0f, 20.0f));

        return result;
    }

    @Override
    public boolean insert(Community entity) {
        //插入对象 entity

        return false;
    }

    @Override
    public boolean update(Community entity) {
        String name = entity.name;
        // 查找名称为 name 的小区对象并修改

        return false;
    }

    @Override
    public boolean delete(Community entity) {
        String name = entity.name;
        // 查找名称为 name 的小区对象并删除

        return false;
    }
}
