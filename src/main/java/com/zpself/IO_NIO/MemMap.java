package com.zpself.IO_NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 对比NIO 与io的读取速度
 */
public class MemMap {
    public static void reda() {
        try {
            //String filePath = "C:\\Users\\ying\\Desktop\\Python基础教程（第3版）.pdf";
            String filePath = "C:\\Users\\ying\\Desktop\\1.txt";
            //String filePath = "C:\\Users\\ying\\zpFile\\toolInstall\\newIdea\\idea\\ideaIU-2018.2.4.win.zip";
            //使用内存映射的方式读取文件
            RandomAccessFile file = new RandomAccessFile(filePath,"rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            long startTime = System.currentTimeMillis();
            buffer.clear();
            // 读出所有数据
            while (channel.read(buffer) != -1) {
                buffer.flip();
                buffer.clear();
            }
            file.close();
            channel.close();
            long endTime = System.currentTimeMillis();
            System.out.println("使用内存映射方式读取文件总耗时： "+(endTime - startTime));


           //普通IO流方式
            long startTime1 = System.currentTimeMillis();
            File file1 = new File(filePath);
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
                while (true) {
                    String s = reader.readLine();
                    System.out.println(s);
                    if(s==null)
                        break;
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                    }
                }
            }
            long endTime1 = System.currentTimeMillis();
            System.out.println("使用普通IO流方式读取文件总耗时： "+(endTime1 - startTime1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
