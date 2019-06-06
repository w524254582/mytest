package com.funtl.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName TbContent
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/6 10:19
 * @Version 1.0
 **/
@Data
public class TbContent implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
