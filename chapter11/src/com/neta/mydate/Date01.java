package com.neta.mydate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println("当前时间="+date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        System.out.println(sdf.format(date));

        Date date1 = new Date(121212);

        String s = "2022年04月17日 09:45:15 周日";
        Date parse = sdf.parse(s);
    }
}
