package com.funtl.my.shop.web.admin.service;

import com.funtl.my.shop.commons.persistence.BaseService;
import com.funtl.my.shop.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService extends BaseService<TbContentCategory> {
    /**
     * 根据父级节点ID 查询所有子级节点
     *
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
