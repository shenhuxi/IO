package com.zpself;

import com.zpself.util.IOBase;
import com.zpself.util.IOFile;
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

    @PostMapping("/upload")//上传
    public String upload(){
        return "upload";
    }

    @PostMapping("/download")//下载
    public String download() throws Exception{
        return "download";
    }
    @GetMapping("/countFileString")//统计文件字符数量
    public String testIo() throws Exception{
        return IOBase.countFileString();
    }
    @GetMapping("/changenCode")
    public String changenCode() throws Exception{
        //IOFile.countFileStringByBuffred("使用文件编码的改变");
        IOFile.countFileStringByBuffred();
        return "改变成功！";
    }
}
