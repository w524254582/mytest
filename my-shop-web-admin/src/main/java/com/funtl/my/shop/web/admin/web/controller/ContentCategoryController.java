package com.funtl.my.shop.web.admin.web.controller;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.domain.TbContentCategory;
import com.funtl.my.shop.web.admin.abstracts.AbstractBaseTreeController;
import com.funtl.my.shop.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
public class ContentCategoryController extends AbstractBaseTreeController<TbContentCategory, TbContentCategoryService> {

    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id) {
        TbContentCategory tbContentCategory = null;
        //id不为空，则从数据库获取
        if (id != null) {
            tbContentCategory = service.getById(id);
        } else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }

    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = service.selectAll();
        //排序
        sortList(sourceList, targetList, 0L);

        model.addAttribute("tbContentCategories", targetList);
        return "content_category_list";
    }

    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(TbContentCategory tbContentCategory) {
        return "content_category_form";
    }

    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, RedirectAttributes redirectAttributes, Model model) {

        BaseResult baseResult = service.save(tbContentCategory);

        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/category/list";
        } else {//保存失败
            model.addAttribute("baseResult", baseResult);
            return "content_category_form";
        }
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult=null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            for (String strId : idArray) {
                Long id = strId == null ? 0 : Long.parseLong(strId);
                service.delete(id);
            }
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "tree/data", method = {RequestMethod.GET, RequestMethod.POST})
    public List<TbContentCategory> treeData(Long id) {
        if (id == null) {
            id = 0L;
        }
        return service.selectByPid(id);
    }

}
