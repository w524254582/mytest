package com.funtl.my.shop.web.admin.abstracts;

import com.funtl.my.shop.commons.persistence.BaseEntity;
import com.funtl.my.shop.commons.persistence.BaseTreeDao;
import com.funtl.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName AbstractBaseTreeServiceImpl
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/4 9:09
 * @Version 1.0
 **/
public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity,D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    protected D dao;

    /**
     * 查询全部信息
     *
     * @return
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 删除
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        dao.delete(id);
    }

    /**
     * 根据ID查询信息
     * @param id
     * @return
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }


    /**
     * 更新
     * @param entity
     */
    @Override
    @Transactional(readOnly = false)
    public void update(T entity) {
        dao.update(entity);
    }

    /**
     * 根据父级节点ID 查询所有子级节点
     *
     * @param pid
     * @return
     */
    @Override
    public List<T> selectByPid(Long pid){
        return dao.selectByPid(pid);
    }

}
