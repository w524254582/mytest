package com.funtl.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:Dknight
 * @date:2019/5/23
 * @description:
 */
@Controller
public class MainController {

    @RequestMapping(value = "main", method = RequestMethod.GET)

    public String main() {
        return "main";
    }
}
