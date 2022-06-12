package com.neta.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx05 {
    public static void main(String[] args) {
        // 结巴去重
        String content = "我...我要...要要要学..学学学...java";

        // 去除 ...
        content = Pattern.compile("\\.").matcher(content).replaceAll("");

        // 替换重复的字
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");

        System.out.println(content);

    }
}
