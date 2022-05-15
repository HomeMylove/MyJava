package com.neta.homework;

import java.io.*;

public class Homework01 {
    public static void main(String[] args) {
        File file = new File("E:\\mytemp");
        if(!file.exists()){
            file.mkdir();
            System.out.println("创建mytemp成功");
        }else {
            System.out.println("mytemp已存在");
        }

        File file1 = new File(file, "hello.txt");
        if(file1.exists())
            System.out.println("hello.txt已存在");
        else{
            try {
                file1.createNewFile();
                System.out.println("创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file1);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("窗前明月光");
            bufferedWriter.write("\n");
            bufferedWriter.write("疑是地上霜");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
