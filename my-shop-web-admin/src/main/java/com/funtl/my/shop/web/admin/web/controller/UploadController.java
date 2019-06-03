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
     * @param dropFile   dropZone
     * @param editorFile wangEditor
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> upload(MultipartFile dropFile, MultipartFile editorFile, HttpServletRequest request) {

        Map<String, Object> result = new HashMap<>();
        //前端上传的文件
        MultipartFile myFile = dropFile == null ? editorFile : dropFile;
        // 获取上传的原始文件名
        String fileName = myFile.getOriginalFilename();
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
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //dropZone上传
        if (dropFile != null) {
            result.put("fileName", UPLOAD_PATH + file.getName());
        }else {
            //wangEditor上传
            /**
             * scheme:服务端提供的协议 Http/https
             * serverName：服务器名称 localhost或者ip 或 域名
             * serverPort:服务器端口
             */
            String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            result.put("errno", 0);
            result.put("data", new String[]{serverPath + UPLOAD_PATH + file.getName()});
        }
        return result;
    }
}
