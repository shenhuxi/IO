package com.zpself;

import com.zpself.IO_NIO.CharsetTest;
import com.zpself.IO_NIO.MemMap;
import com.zpself.util.IOBase;
import com.zpself.util.IOFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/NIORead")//上传
    public String upload(){
        MemMap.reda();
        return "NIO读取文件完成！";
    }

    @PostMapping("/CharsetTest")//下载
    public String download(@RequestParam String str) throws Exception{
        CharsetTest.charset(str);
        return "CharsetTest字节码完成转换！";
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

