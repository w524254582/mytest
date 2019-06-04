package com.funtl.my.shop.web.admin.abstracts;

import com.funtl.my.shop.commons.persistence.BaseTreeEntity;
import com.funtl.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @ClassName AbstractBaseTreeController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/4 13:35
 * @Version 1.0
 **/
public abstract class AbstractBaseTreeController<T extends BaseTreeEntity, S extends BaseTreeService<T>> {

    @Autowired
    protected S service;

    /**
     * 跳转列表页
     *
     * @param model
     * @return
     */
    public abstract String list(Model model);

    /**
     * 跳转表单页
     *
     * @param entity
     * @return
     */
    public abstract String form(T entity);

    public abstract String save(T entity, RedirectAttributes redirectAttributes, Model model);


    /**
     * 树形结构
     * @param id
     * @return
     */
    public abstract List<T> treeData(Long id);

    /**
     * 排序
     *
     * @param sourceList 数据源集合
     * @param targetList 排序后的集合
     * @param parentId   父节点的ID
     */
    protected void sortList(List<T> sourceList, List<T> targetList, Long parentId) {
        for (T sourceEntity : sourceList) {
            //如果传过来的parentId和 原集合中的这个parentId相同就在目标集合里加入这个对象。
            if (sourceEntity.getParent().getId().equals(parentId)) {
                targetList.add(sourceEntity);

                //判断有没有子节点，如果有 则继续追加
                if (sourceEntity.getIsParent()) {//是一个父类
                    for (T currentEntity : sourceList) {
                        if (currentEntity.getParent().getId().equals(sourceEntity.getId())) {
                            sortList(sourceList, targetList, sourceEntity.getId());//递归
                            break;
                        }
                    }
                }
            }
        }
    }
}
