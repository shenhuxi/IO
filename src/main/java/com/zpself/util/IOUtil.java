package com.zpself.util;

import java.io.*;

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
    //读取文件夹里面文件
    public static void redaDirectory( String filePath){
        if(filePath==null){
            return;
        }
        File[] files = new File(filePath).listFiles();
        for (File file : files) {
            if(file.isFile()){
                System.out.println(file.getName());
            }else if(file.isDirectory()){
                System.out.println(file.getName());
                redaDirectory(file.getPath());
            }else{
                System.out.println("Error");
            }
        }
    }
    //拷贝文件夹
    public static void redaAndWriteDirectory( File filePath,File order) throws IOException{
        //在目标文件创建文件夹
        File newdir = new File(order, filePath.getName());
        newdir.mkdirs();
        //得到被复制的文件夹 的文件数组
        File[] files = filePath.listFiles();
        for (File file : files) {
            if(file.isFile()){
                BufferedInputStream bf  = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File(newdir,file.getName())));
                int b;
                while((b=bf.read())!=-1){
                    bo.write(b);
                }
                bf.close();
                bo.close();
            }else{
                redaAndWriteDirectory(file,newdir);
            }

        }
    }
}
