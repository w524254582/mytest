package com.funtl.my.shop.web.api.service;

import com.funtl.my.shop.domain.TbContent;

import java.util.List;

/**
 * @ClassName TbContentService
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/5 14:30
 * @Version 1.0
 **/
public interface TbContentService {
    /**
     * 根据类别ID查询内容列表
     *
     * @param categoryId
     * @return
     */
    List<TbContent> selectByCategoryId(Long categoryId);
}
