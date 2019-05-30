package com.funtl.my.shop.web.admin.service;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.commons.dto.PageInfo;
import com.funtl.my.shop.domain.TbContent;
import com.funtl.my.shop.domain.TbUser;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TbContentService
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 16:13
 * @Version 1.0
 **/
public interface TbContentService {
    /**
     * 查询TbContent表全部信息
     * @return
     */
    List<TbContent> selectAll();

    BaseResult save(TbContent tbContent);

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
    PageInfo<TbContent> page(int draw, int start, int length, TbContent TbContent);

    /**
     * 查询总笔数
     * @return
     */
    int count(TbContent tbContent);

}
