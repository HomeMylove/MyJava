package com.neta.mycollection.collection_;

import java.util.HashSet;

public class HashSetExercise {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        set.add(new Employee("Yae",900));
        set.add(new Employee("Ei",100));
        set.add(new Employee("Yae",900));


        set.add(1);
    }
}
