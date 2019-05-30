package com.funtl.my.shop.domain;

import com.funtl.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * 内容管理
 * @ClassName TbContent
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 16:09
 * @Version 1.0
 **/
@Data
public class TbContent extends BaseEntity {

    private Long categoryId;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
