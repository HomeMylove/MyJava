package com.neta.bufferedreader_;

import java.io.*;

public class FileCopy {
    public static void main(String[] args)  {
        String srcPath = "E:\\note.txt";
        String targetPath = "E:\\note-copy.txt";

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(srcPath));
            bufferedWriter = new BufferedWriter(new FileWriter(targetPath));

            String line;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
            }
            System.out.println("拷贝完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
                if(bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
