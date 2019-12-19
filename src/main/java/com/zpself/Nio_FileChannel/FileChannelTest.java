package com.zpself.Nio_FileChannel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:\\Users\\ying\\Desktop\\1.txt";
        //String filePath = "C:\\Users\\ying\\zpFile\\toolInstall\\newIdea\\idea\\ideaIU-2018.2.4.win.zip";
        //使用内存映射的方式读取文件
        RandomAccessFile file = new RandomAccessFile(filePath,"rw");
        FileChannel channel = file.getChannel();
        //channel.transferTo();



    }
}
