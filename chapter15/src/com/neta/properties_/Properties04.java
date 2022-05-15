package com.neta.properties_;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Properties04 {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("E:\\config.properties"));
            properties.setProperty("gender","male");
            properties.setProperty("pwd","1234567890");
            properties.store(new FileWriter("E:\\new-config.properties"),"new config");
            System.out.println("修改成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
