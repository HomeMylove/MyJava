package com.neta.extend;


class A{
    public A(){
        System.out.println("a");
    }
    public A(String name){
        System.out.println("a name");
    }
}

class B extends A{
    public B(){
        this("Yae");
        System.out.println("b");
    }
    public B(String name){
        System.out.println("b name");
    }
}

public class Test{
    public static void main(String[] args){
        B b = new B();
    }
}