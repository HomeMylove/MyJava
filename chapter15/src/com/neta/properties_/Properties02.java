package com.neta.properties_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    public static void main(String[] args) {
        String fileName = "mysql.properties";
        String filePath = Properties02.class.getClassLoader().getResource(fileName).getPath();

        Properties properties = new Properties();
        try {
            properties.load(new FileReader(filePath));
            System.out.println(properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
