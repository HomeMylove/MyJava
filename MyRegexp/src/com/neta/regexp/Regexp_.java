package com.neta.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp_ {
    public static void main(String[] args) {

        String content = "1998年有1234个";

        String regStr = "\\d\\d\\d\\d";

        Pattern pattern = Pattern.compile(regStr);

        Matcher matcher = pattern.matcher(content);
        // 根据指定的规则去匹配字符串

        while (matcher.find())
            System.out.println("找到:"+matcher.group(0));

    }
}
