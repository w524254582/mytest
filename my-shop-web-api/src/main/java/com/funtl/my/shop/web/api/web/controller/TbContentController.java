package com.funtl.my.shop.web.api.web.controller;

import com.funtl.my.shop.domain.TbContent;
import com.funtl.my.shop.web.api.service.TbContentService;
import com.funtl.my.shop.web.api.web.dto.TbContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TbContentController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/5 14:32
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "content")
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id) {
        TbContent tbContent = null;
        if (id == null) {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    @RequestMapping(value = "findContentByCategoryId", method = RequestMethod.GET)
    public List<TbContentDTO> findContentByCategoryId(Long categoryId) {
        List<TbContentDTO> tbContentDTOS = null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId(categoryId);
        if (tbContents != null && tbContents.size() > 0) {
            tbContentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbContentDTO dto = new TbContentDTO();
                BeanUtils.copyProperties(tbContent, dto);//反射原dao到目标dto里的字段
                tbContentDTOS.add(dto);
            }
        }
        return tbContentDTOS;
    }

}
