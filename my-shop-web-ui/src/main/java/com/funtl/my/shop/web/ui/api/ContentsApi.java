package com.funtl.my.shop.web.ui.api;

import com.funtl.my.shop.commons.utils.HttpClientUtils;
import com.funtl.my.shop.commons.utils.MapperUtils;
import com.funtl.my.shop.web.ui.dto.TbContent;

import java.util.List;

/**
 * 内容管理接口
 * @ClassName ContentsApi
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/6 10:45
 * @Version 1.0
 **/
public class ContentsApi {


    public static List<TbContent> findContentsByCategoryId(String id) {
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS+id);
        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }

    public static  List<TbContent> ppt() {
        List<TbContent> tbContents = findContentsByCategoryId("89");

        return tbContents;
    }
}
