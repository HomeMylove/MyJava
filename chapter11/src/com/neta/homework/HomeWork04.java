package com.neta.homework;

public class HomeWork04 {
    public static void main(String[] args) {
        String str = "Hello World I love Java and I love JavaScript 2015, also called ES6";
        count(str);
//        Object
    }

    public static void count(String str){
        int big = 0;
        int small = 0;
        int num = 0;

        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char current = chars[i];
            if(current >= '0' && current <= '9'){
                num++;
            }
            if(current >= 'a' && current <= 'z'){
                small++;
            }
            if(current >= 'A' && current <= 'Z'){
                big++;
            }
        }

        System.out.println("大写字母:"+big+"\n小写字母:"+small+"\n数字:"+num);

    }
}


