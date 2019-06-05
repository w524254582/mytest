package com.funtl.my.shop.web.api.dao;

import com.funtl.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TbContentDao
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/5 14:22
 * @Version 1.0
 **/
@Repository
public interface TbContentDao {
    /**
     * 根据类别ID查询内容列表
     *
     * @param tbContent
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
