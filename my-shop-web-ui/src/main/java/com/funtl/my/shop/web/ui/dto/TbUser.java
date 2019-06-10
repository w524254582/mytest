package com.funtl.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName TbUser
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/6 14:21
 * @Version 1.0
 **/
@Data
public class TbUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String verification;
}
