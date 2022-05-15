package com.neta.filewriter_;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "E:\\note.txt";
        FileWriter fileWriter = null;
        String words = "窗前明月光，撒了一碗汤\n";

        try {
            fileWriter = new FileWriter(filePath,true);
            fileWriter.write(words.toCharArray());
//            fileWriter.write(words);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
