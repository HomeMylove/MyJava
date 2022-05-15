package com.neta.properties_;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties03 {
    public static void main(String[] args) {
        Properties properties = new Properties();

//        创建
        properties.setProperty("charset","utf8");
        properties.setProperty("usr","root");
        properties.setProperty("pwd","neta");
//      将 k - v 写入
        try {
            properties.store(new FileWriter("E:\\config.properties"),null);
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
