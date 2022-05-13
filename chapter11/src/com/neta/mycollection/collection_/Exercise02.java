package com.neta.mycollection.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise02 {
    public static void main(String[] args) {
        List strArr = new ArrayList<>();

        strArr.add("Java");
        strArr.add("C++");
        strArr.add("C");
        strArr.add("C#");
        strArr.add("python");
        strArr.add("html");
        strArr.add("golang");
        strArr.add("javascript");
        strArr.add("ruby");
        strArr.add("php");
        strArr.add("linux");

        System.out.println("之前");
        for (Object o : strArr) {
            System.out.println(o);
        }

        System.out.println("之后");
        strArr.add(2,"韩顺平教育");
        System.out.println("第五个是"+strArr.get(5));
        strArr.remove(6);
        strArr.set(7,"vue");

        Iterator iterator = strArr.iterator();

        while (iterator.hasNext()) {
            Object str =  iterator.next();
            System.out.println(str);
        }

    }
}
