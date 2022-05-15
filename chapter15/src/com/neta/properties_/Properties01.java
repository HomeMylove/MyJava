package com.neta.properties_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Properties01 {
    public static void main(String[] args) {
        String fileName = "mysql.properties";
        String filePath = Properties01.class.getClassLoader().getResource(fileName).getPath();
        BufferedReader bufferedReader = null;

        try {
            // 读取 mysql.properties 文件，并得到 ip,user,pwd
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] split = line.split("=");
                System.out.println(split[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
