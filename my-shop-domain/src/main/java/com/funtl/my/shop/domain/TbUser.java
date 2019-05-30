package com.funtl.my.shop.domain;/**
 * TbUser
 *
 * @author Administrator
 * @version 1.0
 * 2019/5/24 10:57
 **/

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.funtl.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/**
 *@ClassName TbUser
 *@Description TODO
 *@Author Administrator
 *@Date 2019/5/24 10:57
 *@Version 1.0
 **/
@Data
public class TbUser extends BaseEntity {
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
}
