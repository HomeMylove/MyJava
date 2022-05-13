package com.neta.aboutEquals;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o instanceof Person){
            Person p = (Person) o;
            return Objects.equals(this.name, p.name) && this.age == p.age && p.gender == this.gender;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("我走啦");
        super.finalize();
    }
}
