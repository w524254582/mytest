package com.funtl.my.shop.web.ui.controller;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.web.ui.api.UsersApi;
import com.funtl.my.shop.web.ui.constant.SystemConstants;
import com.funtl.my.shop.web.ui.dto.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/6 14:40
 * @Version 1.0
 **/
@Controller
public class LoginController {
    /**
     * 跳转登录页
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(TbUser tbUser, Model model, HttpServletRequest request) throws Exception {
        TbUser user = UsersApi.login(tbUser);
        //登录失败
        if (user == null) {
            model.addAttribute("baseResult", BaseResult.fail("用户名或密码错误,请重新输入"));
            return "login";
        } else {//登陆成功
            request.getSession().setAttribute(SystemConstants.SESSION_USER_KEY, user);
            return "redirect:/index";
        }
    }

    /**
     * 注销
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }
}
