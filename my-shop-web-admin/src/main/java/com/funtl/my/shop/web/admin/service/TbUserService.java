package com.funtl.my.shop.web.admin.service;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.commons.dto.PageInfo;
import com.funtl.my.shop.commons.persistence.BaseService;
import com.funtl.my.shop.domain.TbUser;

import java.util.List;

/**
 * TbUserService
 *
 * @author kdnight
 * @version 1.0
 * 2019/5/24 11:01
 **/
public interface TbUserService extends BaseService<TbUser> {
    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);
}
