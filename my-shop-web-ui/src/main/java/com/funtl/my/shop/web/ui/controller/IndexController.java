package com.funtl.my.shop.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/5 16:27
 * @Version 1.0
 **/
@Controller
public class IndexController {

    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
