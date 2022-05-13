package com.neta.mywrapper;

public class Wrapper01 {
    public static void main(String[] args) {
        Integer i = 100;
        String s1 = i + "";
        String s2 = i.toString();
        String s3 = String.valueOf(i);

        String str = "12345";
        Integer n1 = Integer.parseInt(str);
        Integer integer = new Integer(str);
    }
}


