package com.funtl.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.funtl.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 分类管理
 * @ClassName TbContentCategory
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 11:21
 * @Version 1.0
 **/
@Data
public class TbContentCategory extends BaseEntity {
    @NotNull
    private Long parentId;
    @NotNull
    private String name;
    @NotNull
    private Integer statuc;
    @NotNull
    private Integer sortOrder;
    @JsonProperty(value = "isParent")
    private Boolean isParent;
}
