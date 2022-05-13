package com.neta.generic;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Generic02 {
    public static void main(String[] args) {
        Student yae = new Student("Yae", 900);
        Student ei = new Student("Ei", 800);
        Student ayaka = new Student("Ayaka", 18);

        HashSet<Student> set = new HashSet<>();

        set.add(yae);
        set.add(ei);
        set.add(ayaka);

        System.out.println(set);

        HashMap<String, Student> map = new HashMap<>();

        map.put("yae",yae);
        map.put("ei",ei);
        map.put("ayaka",ayaka);


        for (Student value : map.values()) {
            System.out.println(value);
        }

        for (Map.Entry<String, Student> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }


    }
}

@SuppressWarnings({"all"})
class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
