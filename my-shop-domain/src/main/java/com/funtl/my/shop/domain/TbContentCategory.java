package com.funtl.my.shop.domain;

import com.funtl.my.shop.commons.persistence.BaseEntity;

/**
 * 分类管理
 * @ClassName TbContentCategory
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 11:21
 * @Version 1.0
 **/

public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private Integer statuc;
    private Integer sortOrder;
    private Boolean isParent;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatuc() {
        return statuc;
    }

    public void setStatuc(Integer statuc) {
        this.statuc = statuc;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}
