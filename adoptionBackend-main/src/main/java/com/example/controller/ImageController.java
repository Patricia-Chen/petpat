package com.example.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
public class ImageController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //将yml中的自定义配置注入到这里
    @Value("${gorit.file.root.path}")
    private String imagePath;
    private final Logger log = LoggerFactory.getLogger("ImageController");

    private final String accessKeyId = "LTAI5tJQGeQkSbNuJafZdG8W";
    private final String accessKeySecret = "5KigwWrbLBXz8Zg7GHYnm2hlo3YpEB";
    private final String endpoint = "oss-cn-shanghai.aliyuncs.com";
    private final String bucketName = "petpatimages";
    private final String basePath = "pets/";

    @PostMapping("/image")
    @CrossOrigin
    public String fileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {
        // 获取上传的文件名称
        String fileName = file.getOriginalFilename();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try{
            // 上传文件到云盘
            ossClient.putObject(bucketName, basePath + fileName, file.getInputStream());

            Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);

            // 返回云盘上的文件URL
            return ossClient.generatePresignedUrl(bucketName, basePath + fileName, expiration).toString();

        }catch(IOException e){
            log.error(e.toString());
        }finally {
            ossClient.shutdown();
        }
        return "上传错误";
    }

}
