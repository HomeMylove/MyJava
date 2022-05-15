package com.neta.inputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {
//        readFile01();
        readFile02();
    }

    public static void readFile01(){
        String filePath = "E:\\hello.txt";
        int read = 0;
        FileInputStream fileInputStream = null;
        try {
//            创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
//            从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止
//            如果返回 -1， 表示读取完毕
            while ((read = fileInputStream.read()) != -1){
                System.out.print((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            关闭文件，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFile02(){
        String filePath = "E:\\hello.txt";
        byte[] buf = new byte[8];
        FileInputStream fileInputStream = null;
        int len = 0;
        try {
//            创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
//            从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止
//            如果返回 -1， 表示读取完毕
            while ((len = fileInputStream.read(buf)) != -1){
                System.out.println(new String(buf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            关闭文件，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
