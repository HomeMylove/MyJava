package com.neta.regexp;

import java.awt.event.PaintEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx02 {
    public static void main(String[] args) {
        String content = "20220612";

        String regStr01 = "(\\d{4})(\\d{2})(\\d{2})";
        String regStr02 = "(?<year>\\d{4})(?<month>\\d{2})(?<day>\\d{2})";


        Pattern pattern1 = Pattern.compile(regStr01);
        Matcher matcher1 = pattern1.matcher(content);
//
        while (matcher1.find()){
            System.out.println("全部:"+matcher1.group(0));
            System.out.println("年:"+matcher1.group(1));
            System.out.println("月:"+matcher1.group(2));
            System.out.println("日:"+matcher1.group(3));
        }

        Pattern pattern2 = Pattern.compile(regStr02);
        Matcher matcher2 = pattern2.matcher(content);

        while (matcher2.find()){
            System.out.println("全部:"+matcher2.group(0));
            System.out.println("年:"+matcher2.group("year"));
            System.out.println("月:"+matcher2.group("month"));
            System.out.println("日:"+matcher2.group("day"));
        }
    }
}
