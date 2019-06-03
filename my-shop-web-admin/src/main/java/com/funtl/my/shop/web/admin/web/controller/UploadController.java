package com.funtl.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName UploadController
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/31 15:38
 * @Version 1.0
 **/
@Controller
public class UploadController {
    private static final String UPLOAD_PATH = "/static/upload/";

    /**
     * 文件上传
     *
     * @param dropFile
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropFile, HttpServletRequest request) {

        Map<String, Object> result = new HashMap<>();
        // 获取上传的原始文件名
        String fileName = dropFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        System.out.println(filePath);
        // 获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        // 判断并创建上传用的文件夹
        File file = new File(filePath);

        if (!file.exists()) {
            file.mkdir();
        }

        // 重新设置文件名为 UUID，以确保唯一
        file = new File(filePath, UUID.randomUUID() + fileSuffix);

        try {
            // 写入文件
            dropFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.put("fileName", UPLOAD_PATH+file.getName());
        return result;
    }
}
