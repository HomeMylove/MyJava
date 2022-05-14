package com.neta.exercie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        fileCopy();
    }

    public static void fileCopy(){
        String sourcePath = "E:\\dva.jpg";
        FileInputStream fileInputStream = null;
        byte[] buf = new byte[1024];
        int len = 0;
        String targetPath = "E:\\dvacopy.jpg";
        FileOutputStream fileOutputStream = null;



        try {
          fileInputStream  =  new FileInputStream(sourcePath);
          fileOutputStream = new FileOutputStream(targetPath);
          while ((len = fileInputStream.read(buf))!=-1){
              fileOutputStream.write(buf,0,len);
          }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
