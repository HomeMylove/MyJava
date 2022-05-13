package com.neta.mystatic;

public class ChildGame {
    public static void main(String[] args) {
        Child yae = new Child("Yae");
        System.out.println("num=" + yae.count);
        Child ei = new Child("Ei");
        System.out.println("num=" + ei.count);
    }
}

class Child {
    private String name;
    public static int count = 0; // 静态变量

    public Child(String name) {
        this.name = name;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
