package com.funtl.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层的基类
 * @ClassName BaseDao
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/3 14:48
 * @Version 1.0
 **/
public interface BaseDao<T extends BaseEntity> {
    /**
     * 查询TbContent表全部信息
     * @return
     */
    List<T> selectAll();

    void insert(T entity);

    void delete(Long id);

    T getById(Long id);

    void update(T entity);


    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params, 需要两个参数 start 记录开始位置和 length 每页记录数
     * @return
     */
    List<T> page(Map<String,Object> params);

    /**
     * 查询总笔数
     * @return
     */
    int count(T entity);
}
