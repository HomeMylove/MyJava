package com.neta.mystringbuffer;

import java.util.Scanner;

public class StringBufferExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入商品名");
        String name = scanner.next();
        System.out.println("输入商品价格");
        String price = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(price);
        int index = stringBuffer.lastIndexOf(".");
        index = index == -1 ? stringBuffer.length()-1 : index;
        while (index > 3){
            index -= 3;
            stringBuffer.insert(index,",");
        }
        String info = "商品名\t商品价格\n%s\t%s";
        System.out.println(String.format(info,name,stringBuffer));
    }
}
