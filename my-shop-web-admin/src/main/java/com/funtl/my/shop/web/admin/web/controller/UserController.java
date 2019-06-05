package com.funtl.my.shop.web.admin.web.controller;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.domain.TbUser;
import com.funtl.my.shop.web.admin.abstracts.AbstractBaseController;
import com.funtl.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 用户管理
 *
 * @ClassName UserController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/25 10:25
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractBaseController<TbUser, TbUserService> {


    @ModelAttribute
    public TbUser getTbUser(Long id) {
        TbUser tbUser = null;
        //id不为空，则从数据库获取
        if (id != null) {
            tbUser = service.getById(id);
        } else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * 跳转到用户列表页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user_list";
    }

    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }

    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, RedirectAttributes redirectAttributes, Model model) {
        BaseResult baseResult = service.save(tbUser);

        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        } else {//保存失败
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }
    }

/*    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除数据成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }*/


    @Override
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "user_detail";
    }
}
