package com.zpself;

import com.zpself.service.FileService;
import com.zpself.util.IOFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/testIo")//下载
    public String testIo() throws Exception{
        return fileService.testIo();
    }
    @GetMapping("/changenCode")
    public String changenCode() throws Exception{
        IOFile.countFileStringByBuffred("使用文件编码的改变");
        return "改变成功！";
    }
}
