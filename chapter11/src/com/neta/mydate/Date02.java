package com.neta.mydate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Date02 {
    public static void main(String[] args) {
        MyCalender instance = MyCalender.getInstance();
        Calendar instance1 = Calendar.getInstance();
        instance1.get(Calendar.YEAR);


        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss");


        System.out.println(dateTimeFormatter.format(now));


    }
}

abstract class MyCalender{
    public static C getInstance(){
        return new C();
    }

    public static class C extends MyCalender{}
}
