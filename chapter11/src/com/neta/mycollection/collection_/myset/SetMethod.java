package com.neta.mycollection.collection_.myset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetMethod {
    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add(null);

        set.add("hello");

        set.add(null);
        set.add("YaeMiko");
        set.add(new String("YaeMiko"));

        for(int i = 0; i < 100; i++){
            set.add(i);
        }



//        // 获取迭代器
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Object next = iterator.next();
//            System.out.println(next);
//        }
//        new HashSet<>();
//
//        for (Object o : set) {
//            System.out.println(o);
//        }
    }
}
