package com.zpself.file;

import org.springframework.util.StringUtils;

import java.io.File;

public class CreadteFile {
    public static void main(String[] args) {
        //String filePath = "C:\\micsdev\\upload\\datapoint";
        //String filePath = "C:\\micsdev\\upload\\patch";
        String filePath = "C:\\Users\\ying\\zpFile\\company\\RDP_File\\data\\material";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        ;
        System.out.println(StringUtils.isEmpty(new Object().toString()));
        replance();
    }
    public static void  replance(){
        String s = "aa   b   c  d   ";
        s= s.replaceAll("\\s+"," ");
        String[] split = s.split(" ");
        for (String s1 : split) {

            System.out.println(s1);
        }
    }
}
