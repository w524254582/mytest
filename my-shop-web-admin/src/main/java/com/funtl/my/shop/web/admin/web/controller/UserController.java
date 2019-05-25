package com.funtl.my.shop.web.admin.web.controller;

import com.funtl.my.shop.domain.TbUser;
import com.funtl.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 *用户管理
 *@ClassName UserController
 *@Description TODO
 *@Author Administrator
 *@Date 2019/5/25 10:25
 *@Version 1.0
 **/
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private TbUserService tbUserService;


    /**
     * 跳转到用户列表页
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }

    @RequestMapping(value = "save" ,method = RequestMethod.POST)
    public String save(TbUser tbUser, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("");
        return "redirect:/user/list";
    }


}
