package com.neta.myexception;

import java.util.Scanner;

public class Exception01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true){
            System.out.println("输入一个整数");
            try {
                String word = scanner.next();
                 i = Integer.parseInt(word);
                break;
            } catch (Exception e) {
                System.out.println("输入错误");
            }
        }
        System.out.println("不错"+i);

    }
}

class A{}
class B extends A{}
class C extends A{}