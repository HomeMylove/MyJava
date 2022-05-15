package com.neta.bufferedreader_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\note.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null)
            System.out.println(line);
        bufferedReader.close();

    }


}
