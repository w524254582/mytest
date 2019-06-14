package com.funtl.my.shop.web.ui.controller;

import com.funtl.my.shop.web.ui.api.ContentsApi;
import com.funtl.my.shop.web.ui.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
    public String index(Model model){
        //请求幻灯片
        requestContentsPPT(model);
        return "index";
    }

    /**
     * 请求幻灯片
     * @param model
     */
    private void requestContentsPPT(Model model){
        List<TbContent> tbContents = ContentsApi.ppt();
        model.addAttribute("ppt", tbContents);
    }
}


