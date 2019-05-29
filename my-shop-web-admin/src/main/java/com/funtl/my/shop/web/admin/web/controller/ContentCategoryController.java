package com.funtl.my.shop.web.admin.web.controller;

import com.funtl.my.shop.domain.TbContentCategory;
import com.funtl.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ContentCategoryController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 11:31
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {

    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = tbContentCategoryService.selectAll();
        //排序
        sortList(sourceList, targetList, 0L);

        model.addAttribute("tbContentCategories", targetList);
        return "content_category_list";
    }

    /**
     * 排序
     * @param sourceList 数据源集合
     * @param targetList 排序后的集合
     * @param parentId 父节点的ID
     */
    private void sortList(List<TbContentCategory> sourceList, List<TbContentCategory> targetList,Long parentId) {
        for (TbContentCategory tbContentCategory : sourceList) {
            //如果传过来的parentId和 原集合中的这个parentId相同就在目标集合里加入这个对象。
            if (tbContentCategory.getParentId().equals(parentId)) {
                targetList.add(tbContentCategory);

                //判断有没有子节点，如果有 则继续追加
                if (tbContentCategory.getParent()) {//是一个父类
                    for (TbContentCategory contentCategory : sourceList) {
                        if (contentCategory.getParentId().equals(tbContentCategory.getId())) {
                            sortList(sourceList, targetList, tbContentCategory.getId());//递归
                            break;
                        }
                    }
                }
            }
        }
    }

}
