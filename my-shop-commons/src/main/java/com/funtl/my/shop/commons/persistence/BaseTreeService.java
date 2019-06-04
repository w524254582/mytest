package com.funtl.my.shop.commons.persistence;

import com.funtl.my.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * 通用的树形结构接口
 * @ClassName BaseTreeService
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/4 8:55
 * @Version 1.0
 **/
public interface BaseTreeService<T extends BaseEntity> {
    /**
     * 查询全部信息
     * @return
     */
    List<T> selectAll();

    BaseResult save(T entity);

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
