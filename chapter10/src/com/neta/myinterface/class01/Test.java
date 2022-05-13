package com.neta.myinterface.class01;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();

    }
}

class Cat implements USB{

    @Override
    public void say() {
        System.out.println("meow");
    }

    @Override
    public void hi() {
        System.out.println("hello");
    }
}
