package com.zpself.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOBase {
    //1.读取文件  统计字符数据量多少 并排序
    public  static String countFileString() throws IOException{
        StringBuilder sb = new StringBuilder();
        InputStream is= new FileInputStream(new File("C:/Users/ying/zpFile/project/test/test.txt")) ;
        byte[] b = new byte[1024];
        int read;
        while((read = is.read(b))!=-1){
            sb.append(new String(b,0,read));
        }
        return sb.toString();
    }

}
