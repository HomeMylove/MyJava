package com.neta.homework;

import java.io.*;
import java.util.ArrayList;

public class Homework02 {
    public static void main(String[] args) {
        File file = new File("E:\\poem.txt");
        BufferedWriter bufferedWriter = null;
        ArrayList<String> strs = new ArrayList<>();
        strs.add("为了你");
        strs.add("我变成狼人模样");
        strs.add("为了你");
        strs.add("染上了疯狂");
        strs.add("染为了你");
        strs.add("穿上厚厚的伪装");
        strs.add("为了你");
        strs.add("换了心肠");
        strs.add("我们还能不能能不能再见面");
        strs.add("我在佛前苦苦求了几千年");

        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"gbk"));
            for (String str : strs) {
                bufferedWriter.write(str+"\n");
            }
            System.out.println("写入成功");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
            String line;
            int index = 1;
            while ((line = bufferedReader.readLine()) != null){
                String word = index++ + line;
                System.out.println(word);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
