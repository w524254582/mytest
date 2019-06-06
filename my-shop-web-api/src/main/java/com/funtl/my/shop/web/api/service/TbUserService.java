package com.funtl.my.shop.web.api.service;

import com.funtl.my.shop.domain.TbUser;

/**
 * 会员管理
 * @ClassName TbUserService
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/6 13:45
 * @Version 1.0
 **/
public interface TbUserService {
    /**
     * 登陆
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
