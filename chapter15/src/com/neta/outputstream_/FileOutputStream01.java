package com.neta.outputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream01 {
    public static void main(String[] args) {
        writeFile();
    }

    public static void writeFile(){
//        创建 FileOutputStream 对象
        String filePath = "E:\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
//            1.new FileOutputStream(filePath) 创建方式，当写入内容时，会覆盖
//            2.new FileOutputStream(filePath, true) 创建方式,当写入内容时，会追加到末尾
           fileOutputStream =  new FileOutputStream(filePath,true);
//           fileOutputStream.write('a');
            String str = "Hello World";
            fileOutputStream.write(str.getBytes());
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
