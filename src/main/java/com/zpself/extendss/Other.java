package com.zpself.extendss;

public class Other {
    public static  void  san(){
        int a = 10;
        int b=2;
        int c=0;
        int d = a>b ? b : a;
    }
    public static  void  stringBuffer(){
        StringBuilder sbOrder = new StringBuilder("0123456789");
        System.out.println(sbOrder.indexOf("89"));
        System.out.println(sbOrder.substring(9,sbOrder.length()));
        sbOrder=new StringBuilder(sbOrder.substring(sbOrder.indexOf("89")+"89".length()));
        System.out.println(sbOrder.toString());
    }

    public static void main(String[] args) {
        stringBuffer();
    }
}
