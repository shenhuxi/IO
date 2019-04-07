package com.zpself;

import com.zpself.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zengpeng on 2019/3/28
 */
@SpringBootApplication
@RestController
public class SpringSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }
    @Autowired
    FileService fileService;

    @PostMapping("/upload")//上传
    public String upload(){
        fileService.upload();
        return "upload";
    }

    @PostMapping("/download")//下载
    public String download() throws Exception{
        fileService.download();
        return "download";
    }
}
