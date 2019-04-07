package com.zpself.util;

import java.io.*;

public class IOBase {
    //1.读取文件  统计字符数据量多少 并排序
    //自定义数组
    public  static String countFileString() throws IOException{
        StringBuilder sb = new StringBuilder();
        InputStream is= new FileInputStream(new File("C:/Users/ying/zpFile/project/test/test.txt")) ;
        byte[] b = new byte[1024];
        int read;
        while((read = is.read(b))!=-1){
            sb.append(new String(b,0,read));//这种形式会造成两次读取间隙乱码...改用buffred的读取一行
        }
        is.close();
        return sb.toString();
    }

    /**
     *  字符流打印行
     * @param buffred
     * @return
     * @throws IOException
     */
    public  static String countFileString(String buffred) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader is= new BufferedReader(new FileReader(
                new File("C:/Users/ying/zpFile/project/test/test.txt"))) ;
        String s=null;
        byte[] b = new byte[1024];
        int read;
        while(( s = is.readLine())!=null){
            sb.append(s).append("\r\n");//这种形式会造成两次读取间隙乱码...改用buffred的读取一行
        }
        is.close();
        return sb.toString();
    }

}
