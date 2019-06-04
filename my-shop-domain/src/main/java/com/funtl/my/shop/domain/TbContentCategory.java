package com.funtl.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.funtl.my.shop.commons.persistence.BaseTreeEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
public class TbContentCategory extends BaseTreeEntity {
    @Length(min = 1,max = 20,message = "分类名称必须介于1-20位之间")
    private String name;

    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    @JsonProperty(value = "isParent")
    private Boolean isParent;

    private TbContentCategory parent;

}
