package com.funtl.my.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName BaseTreeEntity
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/4 13:50
 * @Version 1.0
 **/
@Data
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    private Boolean isParent;
}
