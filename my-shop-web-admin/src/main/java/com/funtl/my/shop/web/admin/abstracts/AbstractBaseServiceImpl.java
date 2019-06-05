package com.funtl.my.shop.web.admin.abstracts;

import com.funtl.my.shop.commons.dto.PageInfo;
import com.funtl.my.shop.commons.persistence.BaseDao;
import com.funtl.my.shop.commons.persistence.BaseEntity;
import com.funtl.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用的由统一的抽象类来重写，而不应在具体类的实现里重写方法
 *
 * @ClassName AbstractsBaseServiceImpl
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/4 10:02
 * @Version 1.0
 **/
public abstract class AbstractBaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {
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
     * 删除用户信息
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }

    /**
     * 更新用户信息
     *
     * @param entity
     */
    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);
    }

    /**
     * 查询总笔数
     *
     * @return
     */
    @Override
    public int count(T entity) {
        return dao.count(entity);
    }


    /**
     * 分页查询
     *
     * @param draw
     * @param start
     * @param length
     * @param entity
     * @return
     */
    @Override
    public PageInfo<T> page(int draw, int start, int length, T entity) {
        int count = count(entity);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(params));
        return pageInfo;
    }
}
