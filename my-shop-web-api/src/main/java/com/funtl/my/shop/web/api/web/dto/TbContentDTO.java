package com.funtl.my.shop.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据传输对象
 *
 * @ClassName TbContentDTO
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/5 15:00
 * @Version 1.0
 **/
@Data
public class TbContentDTO implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
