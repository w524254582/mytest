package com.funtl.my.shop.web.admin.dao;

import com.funtl.my.shop.commons.persistence.BaseDao;
import com.funtl.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TbContentDao
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 16:13
 * @Version 1.0
 **/
@Repository
public interface TbContentDao extends BaseDao<TbContent> {

    /**
     * 查询TbContent表全部信息
     * @return
     */
    List<TbContent> selectAll();

    void insert(TbContent tbContent);

    void delete(Long id);

    TbContent getById(Long id);

    void update(TbContent tbContent);


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
    List<TbContent> page(Map<String,Object> params);

    /**
     * 查询总笔数
     * @return
     */
    int count(TbContent tbContent);



}
