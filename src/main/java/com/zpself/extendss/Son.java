package com.zpself.extendss;

public class Son extends Father{
    public static void main(String[] args) {
        Son tom = new Son();
        tom.setAge(1);
        System.out.println("系统默认编码为："+ System.getProperty("file.encoding"));
    }
}
