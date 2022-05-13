package com.neta.mycollection.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise01 {
    public static void main(String[] args) {
        Dog wang = new Dog("旺财", 11);
        Dog fugui = new Dog("富贵", 1);
        Dog sada = new Dog("定春", 2);

        List dogs = new ArrayList<>();

        dogs.add(wang);
        dogs.add(fugui);
        dogs.add(sada);

        Iterator iterator = dogs.iterator();

        System.out.println("使用迭代器");
        while (iterator.hasNext()) {
            Object dog = iterator.next();
            System.out.println(dog);
        }

        System.out.println("使用for");
        for (Object dog : dogs) {
            System.out.println(dog);
        }

        for (int i = 0; i < dogs.size();i++) {
            
        }

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
