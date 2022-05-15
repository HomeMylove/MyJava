package com.neta.iostream;

import java.io.File;

public class Directory {
    public static void main(String[] args) {
//    new Directory().m1();
//    new Directory().m2();
    new Directory().m3();

    }

    public void m1(){
        String fileName = "E:\\hello.txt";
        File file = new File(fileName);

        if(file.exists()){
            System.out.println("存在");
        }
    }

    public void m2(){
        String dirPath = "E:\\a\\b\\c";
        File file = new File(dirPath);

        if(file.exists()){
            System.out.println("存在");
        }else{
            System.out.println("不存在");
            if(file.mkdirs()){
                System.out.println("创建成功");
            }
        }
    }

    public void m3(){
        String dirPath = "E:\\a\\b\\c\\hello.txt";
        File file = new File(dirPath);

        if(file.exists()){
            if(file.delete()){
                System.out.println("删除成功");
            }
        }
    }
}
