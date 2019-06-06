package com.funtl.my.shop.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName RegisterController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/6 15:43
 * @Version 1.0
 **/
@Controller
public class RegisterController {
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register() {
        return "register";
    }
}
