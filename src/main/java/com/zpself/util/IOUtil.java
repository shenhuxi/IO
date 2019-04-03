package com.zpself.util;

import java.io.File;
import java.io.IOException;

/**
 * Created by zengpeng on 2019/4/3
 */
public class IOUtil {
    //1、创建文件
    //2、读取文件夹里面文件
    //3、拷贝文件夹

    //创建文件
    public static void createNewFile(){
        File file = new File("D:" + File.separator + "test.txt");
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void redaDirectory( String filePath){
        if(filePath==null){
            return;
        }
        File[] files = new File(filePath).listFiles();
        for (File file : files) {
            if(file.isFile()){
                System.out.println(file.getName());
            }else if(file.isDirectory()){
                redaDirectory(file.getPath());
            }else{
                System.out.println("Error");
            }
        }
    }

}
