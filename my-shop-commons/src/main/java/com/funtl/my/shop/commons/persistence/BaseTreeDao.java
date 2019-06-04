package com.funtl.my.shop.commons.persistence;

import java.util.List;

/**
 * 通用的树形结构接口
 * @ClassName BaseTree
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/4 8:53
 * @Version 1.0
 **/
public interface BaseTreeDao<T extends BaseEntity> {
    /**
     * 查询全部信息
     * @return
     */
    List<T> selectAll();

    void insert(T entity);

    void delete(Long id);

    T getById(Long id);

    void update(T entity);
    /**
     * 根据父级节点ID 查询所有子级节点
     *
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);

}
