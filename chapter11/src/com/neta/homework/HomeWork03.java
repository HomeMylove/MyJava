package com.neta.homework;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入人名");

        String name = "Yae Miko Ei";

        System.out.println(changeName(name));

        print(name);

    }

    public static String changeName(String name) {
        String[] names = name.split(" ");
        StringBuilder sb = new StringBuilder(names[2]);
        sb.append("," + names[0]);
        sb.append("." + names[1].charAt(0));
        return new String(sb);
    }

    public static void print(String name){
        if(name == null){
            System.out.println("name不能为空");
        }

        String[] names = name.split(" ");

        if(names.length != 3){
            System.out.println("字符串格式不对");
        }

        System.out.println(String.format("%s,%s.%s",names[2],names[0],names[1].charAt(0)));
    }
}
