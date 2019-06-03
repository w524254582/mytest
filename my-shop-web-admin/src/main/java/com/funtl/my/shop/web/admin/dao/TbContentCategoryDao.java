package com.funtl.my.shop.web.admin.dao;

import com.funtl.my.shop.commons.persistence.BaseDao;
import com.funtl.my.shop.domain.TbContent;
import com.funtl.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao extends BaseDao<TbContentCategory> {
    /**
     * 根据父级节点ID 查询所有子级节点
     *
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
