package com.zpself.testPackage;

public class Test_正则 {
    public static void main(String[] args) {
        String s = "/u01/mics/log/OCC_RdbAgent_Sys.log";
        System.out.println(s.substring(s.lastIndexOf("/")+1));

        String s2 = "\""+"sasd";
        System.out.println(s2);
    }
}
