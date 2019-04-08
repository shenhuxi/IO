package com.zpself.util;

import java.util.Scanner;

public class SystemIO {
    public static void main(String[] args) {
        System.out.println("请输入----");
        Scanner sn = new Scanner(System.in);
        int a=sn.nextInt();
        System.out.println("输入结束----"+a);
    }
}
