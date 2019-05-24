package com.funtl.my.shop.web.admin.service;

import com.funtl.my.shop.domain.User;

public interface UserService {
    /**
     * 登陆
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    public User login(String email, String password);
}
