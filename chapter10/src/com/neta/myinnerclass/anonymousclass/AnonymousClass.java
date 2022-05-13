package com.neta.myinnerclass.anonymousclass;

public class AnonymousClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.m1();
    }
}

class Outer{
    private int n1 = 10;
    public void m1(){
        // 基于接口的匿名内部类
        A tiger = new A(){
            @Override
            public void cry() {
                System.out.println("老虎在叫");
            }
        };
        tiger.cry();

        // 基于类的匿名内部类
        Father father = new Father("Yae") {
            @Override
            public void test() {
                super.test();
            }
        };
    }
}

interface A{
    public void cry();
}

class Father{
    private String name;
    public Father(String name){
        this.name = name;
    };
    public void test(){
    }
}