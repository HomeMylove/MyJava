package com.neta.myexception;

import java.util.Scanner;

public class ExceptionExercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("第一个数:");
            int n1 = Integer.parseInt(scanner.next());
            System.out.println("第二个数:");
            int n2 = Integer.parseInt(scanner.next());
            System.out.println("除为"+cal(n1,n2));;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("完毕");
        }
    }

    public static double cal(int n1,int n2) throws ArithmeticException{
        return n1 / n2;
    }
}
