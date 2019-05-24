package com.funtl.my.shop.web.admin.dao;

import com.funtl.my.shop.domain.User;

/**
 * 数据访问层
 * 所以不是login 而是getUser
 * @author:Dknight
 * @date:2019/5/12
 * @description:
 */
public interface UserDao {
    /**
     * 根据邮箱和密码获取用户信息
     * @param email 邮箱
     * @param password 密码
     * @return 用户
     */
    public User getUser(String email, String password);
}
