package com.person.springbootexample.controller;
import com.person.springbootexample.utils.AliyunOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    @Autowired
    private AliyunOssUtil aliyunOssUtil;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String  upload(MultipartFile file){

        try {
            //获取客户端文件名称
            String filename = file.getOriginalFilename();
            //获取后缀名
            String suffix = filename.substring(filename.lastIndexOf("."));
            //产生随机文件名
            String uuid = UUID.randomUUID().toString();
            filename = uuid+suffix;
            //上传文件
            aliyunOssUtil.upload(file.getInputStream(),filename);
        } catch (IOException e) {
            return "error";
        }
        return "SUCCESS";
    }
}
