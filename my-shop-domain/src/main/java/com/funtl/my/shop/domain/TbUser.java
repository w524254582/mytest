package com.funtl.my.shop.domain;/**
 * TbUser
 *
 * @author Administrator
 * @version 1.0
 * 2019/5/24 10:57
 **/

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.funtl.my.shop.commons.persistence.BaseEntity;


import java.util.Date;

/**
 *@ClassName TbUser
 *@Description TODO
 *@Author Administrator
 *@Date 2019/5/24 10:57
 *@Version 1.0
 **/

public class TbUser extends BaseEntity {

    private String username;
    private String password;
    private String phone;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
