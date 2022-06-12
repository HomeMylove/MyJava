package com.neta.homework;

import java.awt.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Homework01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("输入邮箱");

        String email = scanner.next();
//        String email = "neta@gmail.com";

        String regStr = "[a-zA-Z0-9_-]+@([a-zA-Z]+\\.)+[a-zA-Z]+";

        boolean matches = Pattern.matches(regStr, email);

        if(matches)
            System.out.println("正确");


    }
}
