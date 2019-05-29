package com.funtl.my.shop.web.admin.service.impl;

import com.funtl.my.shop.web.admin.dao.TbContentDao;
import com.funtl.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName TbContentServiceImpl
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 16:13
 * @Version 1.0
 **/
@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;
}
