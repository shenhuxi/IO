package com.zpself.util;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IOBase {
    //1.读取文件  统计字符数据量多少 并排序

    /**
     * 1.读取文件到string里
     * 2.循环统计到map中出现次数
     * 3.利用treeMap进行排序
     * @return
     * @throws IOException
     */
    public  static String countFileString() throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader is= new BufferedReader(new FileReader(
                new File("C:/Users/ying/zpFile/project/test/test.txt"))) ;
        String s=null;
        while(( s = is.readLine())!=null){
            sb.append(s);//这种形式会造成两次读取间隙乱码...改用buffred的读取一行
        }
        is.close();
        String order =sb.toString();
        //2.循环统计到map中出现次数
        Map<String ,Integer> map = new HashMap();
        String[] sArr = {"手机","家国","5G","局面"};
        for (int i = 0; i < sArr.length; i++) {
            StringBuilder sbOrder = new StringBuilder(order);
            String str = sArr[i];
            while(sbOrder.indexOf(str)>-1){
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
                sbOrder=new StringBuilder(sbOrder.substring(sbOrder.indexOf(str)+str.length(),sbOrder.length()));
            }
        }
        //3.利用treeMap进行排序
        Map<String ,Integer> tree = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1)>map.get(o2)?-1:1;
            }
        });
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            tree.put(stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
        }
        return tree.toString();
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
