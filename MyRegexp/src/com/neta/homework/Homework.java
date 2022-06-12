package com.neta.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework {
    public static void main(String[] args) {

        String content = "-0.9";

        String regStr = "^[-+]?([1-9]\\d*|0)(\\.?\\d+)?$";

        Pattern compile = Pattern.compile(regStr);

        Matcher matcher = compile.matcher(content);
        while (matcher.find())
            System.out.println("find:"+matcher.group(0));

        boolean matches = Pattern.matches(regStr, content);

        if(matches)
            System.out.println("是");


    }
}
