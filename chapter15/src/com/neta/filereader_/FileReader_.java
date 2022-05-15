package com.neta.filereader_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

        String filePath = "E:\\a.txt";
        FileReader fileReader = null;
        int len = 0;
        char[] buf = new char[8];
        try {
            fileReader = new FileReader(filePath);
//            while ((len = fileReader.read())!=-1){
//                System.out.print((char)len);
//            }
            while ((len = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
