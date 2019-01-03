package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CommunityManager implements EntityManager<Community>{
    private List<Community> list;

    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    private CommunityManager(){
        list = new ArrayList<>();
        list.add(new Community( "知乎社区", 10.0f,10.0f, 10.0f));
        list.add(new Community( "另一个社区", 20.0f,20.0f, 20.0f));
    }

    private static class SingletonFactory{
        private static CommunityManager instance = new CommunityManager();
    }

    public static CommunityManager getInstance(){
        return SingletonFactory.instance;
    }


    @Override
    public List<Community> get() {
        //在这里利用JDBC获取内容
        return this.list;
    }

    public List<Community> get(Float lessProperty){
        if(lessProperty == null)
            return get();

        List<Community> result = new ArrayList<>();
        for(Community community : list){
            if(community.getPropertyFee() >= lessProperty)
                result.add(community);
        }
        return result;
    }

    @Override
    public boolean insert(Community entity) {
        //插入对象 entity
        for(Community community : list){
            if(community.getName().equals(entity.getName())){
                return false;
            }
        }
        list.add(entity);
        return true;
    }

    @Override
    public boolean update(Community entity) {
        String name = entity.getName();
        // 查找名称为 name 的小区对象并修改
        for(Community community : list){
            if(community.getName().equals(name)){
                list.remove(community);
                list.add(entity);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Community entity) {
        String name = entity.getName();
        // 查找名称为 name 的小区对象并删除
        for(Community community : list){
            if(community.getName().equals(name)){
                list.remove(community);
                return true;
            }
        }
        return false;
    }
}
