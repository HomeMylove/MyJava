package com.neta.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx01 {
    public static void main(String[] args) {

        String content = "Hello World happy word";

//        String regStr = "(?i)h\\w{4}";
        String regStr = "h\\w{4}";

        Pattern pattern = Pattern.compile(regStr,Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(content);

        while (matcher.find())
            System.out.println("找到："+matcher.group(0));
    }
}
