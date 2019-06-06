package com.funtl.my.shop.web.api.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * 会员数据传输对象
 * @ClassName TbUserDTO
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/6 15:59
 * @Version 1.0
 **/
@Data
public class TbUserDTO implements Serializable {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
}
