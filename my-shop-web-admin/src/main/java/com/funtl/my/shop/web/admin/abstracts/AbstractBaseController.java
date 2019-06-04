package com.funtl.my.shop.web.admin.abstracts;

import com.funtl.my.shop.commons.persistence.BaseEntity;
import com.funtl.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName AbstractBaseController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/4 10:47
 * @Version 1.0
 **/
public abstract class AbstractBaseController<T extends BaseEntity, S extends BaseService<T>> {
    /**
     * 注入业务逻辑层
     */
    @Autowired
    protected S service;


}
