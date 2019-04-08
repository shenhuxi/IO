package com.zpself.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/ying/zpFile/project/test/test/testPrintStream.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        PrintStream ps = new PrintStream(file);
        ps.print("我在中国  我找不到人生 的意义 了吗？   迷茫    或许不是一种状态");
    }
}
