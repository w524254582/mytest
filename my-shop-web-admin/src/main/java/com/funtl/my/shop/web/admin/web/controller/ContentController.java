package com.funtl.my.shop.web.admin.web.controller;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.commons.dto.PageInfo;
import com.funtl.my.shop.domain.TbContent;
import com.funtl.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.WebContentGenerator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName ContentController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/30 9:41
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "content")
public class ContentController {
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

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model) {
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

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
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

    /**
     * 分页查询
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        //封装datatable需要的结果
        PageInfo<TbContent> pageInfo = tbContentService.page(draw, start, length,tbContent);
        return pageInfo;
    }
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbContent tbContent) {
        return "content_detail";
    }
}
