package com.neta.iostream;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {
//        new FileCreate().create01();
//        new FileCreate().create02();
//        new FileCreate().create03();

    }


    public void create01(){
        String filePath = "E:\\hello.txt";
        File file = new File(filePath);

        try{
            file.createNewFile();
            System.out.println("文件创建成功");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void create02(){
        File parentFile = new File("E:\\");
        String fileName = "world.txt";
        File file = new File(parentFile, fileName);

        try{
            file.createNewFile();
            System.out.println("创建文件成功");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void create03(){
        String parentPath = "E:\\";
        String childPath = "Java.txt";
        File file = new File(parentPath, childPath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
