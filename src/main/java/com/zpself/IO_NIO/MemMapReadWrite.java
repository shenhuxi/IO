package com.zpself.IO_NIO;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 复制文件
 */
public class MemMapReadWrite {

    private static int len;
    public static void main(String[] args) {
        String readFileName = "C:\\Users\\ying\\Desktop\\Python基础教程（第3版）.pdf";
        String writeFileName = "C:\\Users\\ying\\Desktop\\Python基础教程（第3版）2.pdf";

        writeFile(readFileName, writeFileName);
    }
    /**
     * 读文件
     *
     * @param fileName
     * @return
     */
    public static ByteBuffer readFile(String fileName) {
        try {
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            len = (int) file.length();
            FileChannel channel = file.getChannel();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, len);

            return buffer.get(new byte[(int) file.length()]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写文件
     *
     * @param readFileName
     * @param writeFileName
     */
    public static void writeFile(String readFileName, String writeFileName) {
        try {
            RandomAccessFile file = new RandomAccessFile(writeFileName, "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = readFile(readFileName);

            MappedByteBuffer bytebuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, len);
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < len; i++) {
                bytebuffer.put(i, buffer.get(i));
            }
            bytebuffer.flip();
            long endTime = System.currentTimeMillis();
            System.out.println("写文件耗时： " + (endTime - startTime));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
