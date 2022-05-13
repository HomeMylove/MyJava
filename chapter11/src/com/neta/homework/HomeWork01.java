package com.neta.homework;

public class HomeWork01 {
    public static void main(String[] args) {
        String str = "Hello World";


        System.out.println(reverse(str,3,8));
        System.out.println(reverse2(str,3,8));
    }

    public static String reverse(String str,int start,int end){
        if(end - start == 1){
            return str;
        }
        String front = str.substring(0,start);
        String middle = str.substring(start,end);
        String tail = str.substring(end);

        StringBuilder sb = new StringBuilder();
        for(int i =middle.length()-1; i>=0; i--){
            sb.append(middle.charAt(i));
        }

        return front + sb.toString() + tail;
    }

    public static String reverse2(String str,int start,int end){
        if(!(str != null && start >= 0 && end < str.length() && start < end)){
            throw new RuntimeException("参数错误");
        }
        char[] chars = str.toCharArray();
        char temp;
        for(int i = start, j = end -1; i < j; i++,j--){
             temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
