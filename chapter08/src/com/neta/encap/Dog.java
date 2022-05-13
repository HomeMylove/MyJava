package com.neta.encap;

public class Dog {
    String name;
    private int age;

    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        System.out.println("修改age");
        if (age > 120 || age < 1) {
            System.out.println("错误的年龄1-120");
            this.age = 18;
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        System.out.println("查看了age");
        return age;
    }
}
