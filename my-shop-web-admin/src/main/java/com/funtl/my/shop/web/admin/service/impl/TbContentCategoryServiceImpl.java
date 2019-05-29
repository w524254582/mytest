package com.funtl.my.shop.web.admin.service.impl;

import com.funtl.my.shop.domain.TbContentCategory;
import com.funtl.my.shop.web.admin.dao.TbContentCategoryDao;
import com.funtl.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName TbContentCategoryServiceImpl
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 11:31
 * @Version 1.0
 **/
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

}
