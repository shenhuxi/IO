package com.zpself.util;

import java.io.*;

/**
 * Created by zengpeng on 2019/4/3
 */
public class IOFile {
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
    /**
     * buffred类自带缓冲--写出到文件
     */
    public  static String countFileStringByBuffred() throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedInputStream is= new BufferedInputStream(new FileInputStream(
                new File("C:/Users/ying/zpFile/project/test/test.txt"))) ;
        BufferedOutputStream out= new BufferedOutputStream(new FileOutputStream(
                new File("C:/Users/ying/zpFile/project/test/test2.txt"))) ;
        byte[] b = new byte[1024];
        int read;
        while((read=is.read(b))!=-1){
            out.write(b,0,read);
            sb.append(new String(b));
        }
        is.close();
        out.close();
        return sb.toString();
    }
    /**
     * InputStreamReader改变文本的编码格式
     */
    public  static String countFileStringByBuffred(String codeChange) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader is= new BufferedReader(new InputStreamReader(new FileInputStream(
                new File("C:/Users/ying/zpFile/project/test/test.txt")),"UTF-8" )) ;

        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/Users/ying/zpFile/project/test/GBK.txt"), "GBK"));

        int ch;
        while((ch = is.read()) != -1) {
            bw.write(ch);
        }
        bw.close();
        is.close();
        return sb.toString();
    }
}
