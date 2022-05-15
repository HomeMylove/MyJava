package com.neta.objetstream_.transformation_;

import java.io.*;

public class CodeQuestion2 {
    public static void main(String[] args) {
        String filePath = "E:\\poem.txt";
        BufferedWriter bufferedWriter = null;


        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            String words = "为了你~我变成狼人模样";
            bufferedWriter.write(words);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
