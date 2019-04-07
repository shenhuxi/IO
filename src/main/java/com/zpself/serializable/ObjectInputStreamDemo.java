package com.zpself.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws Exception {
        File file  = new File("C:/Users/ying/zpFile/project/test/personSerializable.txt");
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
        Person o = (Person)oos.readObject();
        System.out.println(o.getName());

    }
}
