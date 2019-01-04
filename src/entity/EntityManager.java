package entity;

import java.util.List;

public interface EntityManager<T extends Entity> {

    /**
     * 取得实体列表，不带参数的get()代表获取所有实体，应根据需求中的筛选条件另外编写get()函数的重载版本，即包含参数的get()
     * @return 实体列表
     */
    List<T> get();

    /**
     * 插入实体
     * @param entity 实体信息
     * @return 成功返回true，失败返回false
     */
    boolean insert(T entity);

    /**
     * 更新实体信息，entity，找到对应的实体，再将 entity 中的其余信息写入该实体
     * @param entity 要修改的实体信息
     * @return 成功返回true，失败返回false
     */
    boolean update(T entity);

    /**
     * 删除实体，根据参数entity中的主键信息，找到对应的实体，再删除该实体，entity参数只需包含主键信息即可，其余部分为 null
     * @param entity 实体参数
     * @return 成功返回true，失败返回false
     */
    boolean delete(T entity);
}
