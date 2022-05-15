package com.neta.objetstream_.transformation_;

import java.io.*;

public class CodeQuestion {
    public static void main(String[] args) {
        String filePath = "E:\\note2.txt";
        BufferedReader bufferedReader = null;

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "gbk");
            bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
