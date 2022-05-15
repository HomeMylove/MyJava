package com.neta.homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) {
        File file = new File("E:\\dog.properties");

        Properties properties = new Properties();
        properties.setProperty("name","tom");
        properties.setProperty("age","5");
        properties.setProperty("color","red");

        try {
            properties.store(new FileWriter(file),"class dog");
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
