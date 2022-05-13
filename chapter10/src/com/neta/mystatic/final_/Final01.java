package com.neta.mystatic.final_;

public class Final01 {
    public static void main(String[] args) {
        System.out.println(A.n1);
        System.out.println(A.n2);
    }
}

 class A{
     public static  final int n1=10;
     public static int  n2=16;
     static{
         System.out.println("韩顺平教育~");
     }
 }


