package com.funtl.my.shop.web.admin.web.controller;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.domain.TbContent;
import com.funtl.my.shop.web.admin.abstracts.AbstractBaseController;
import com.funtl.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @ClassName ContentController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/30 9:41
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "content")
public class ContentController extends AbstractBaseController<TbContent,TbContentService> {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id) {
        TbContent tbContent = null;
        //id不为空，则从数据库获取
        if (id != null) {
            tbContent = tbContentService.getById(id);
        } else {
            tbContent = new TbContent();
        }
        return tbContent;
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "content_list";
    }

    @Override
    public String detail() {
        return null;
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "content_form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContent tbContent, RedirectAttributes redirectAttributes, Model model) {
        BaseResult baseResult = tbContentService.save(tbContent);

        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        } else {//保存失败
            model.addAttribute("baseResult", baseResult);
            return "content_form";
        }
    }

/*
    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult=null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            tbContentService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }
*/


    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbContent tbContent) {
        return "content_detail";
    }
}
