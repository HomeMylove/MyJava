package com.neta.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx03 {
    public static void main(String[] args) {

        String content = "hello world";

        String regStr = "h.*?l";

        Pattern compile = Pattern.compile(regStr);

        Matcher matcher = compile.matcher(content);

        while (matcher.find())
            System.out.println("结果:"+matcher.group(0));


    }
}
