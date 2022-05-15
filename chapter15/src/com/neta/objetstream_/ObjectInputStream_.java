package com.neta.objetstream_;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "E:\\data.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

//        读取
//        读取(反序列化)的顺序应该和保存时一致，否则会异常
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readByte());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        System.out.println(ois.readObject());


        ois.close();
    }
}
