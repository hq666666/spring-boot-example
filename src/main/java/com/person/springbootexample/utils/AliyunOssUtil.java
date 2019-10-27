package com.person.springbootexample.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class AliyunOssUtil {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.bucketName}")
    private String  bucketName;
    @Value("${aliyun.oss.flag}")
    private String flag;

    private OSSClient ossClient;

    /**
     * 实例化oss 及对应的属性
     * @return
     */
    private OSS getInstance(){
        if(null == ossClient){
            synchronized (AliyunOssUtil.class){
                ossClient = (OSSClient) new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
            }
        }
        return ossClient;
    }
    public void upload(InputStream stream,String fileName){

        if(Boolean.TRUE.equals(flag)){
            getInstance().putObject(bucketName,fileName,stream);
        }
    }
}
