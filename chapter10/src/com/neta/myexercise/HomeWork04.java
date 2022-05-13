package com.neta.myexercise;

public class HomeWork04 {
    public static void main(String[] args) {
        A a = new A();
        a.innerClass();
    }
}

class A{
    private final String name = "Ei";
    public void innerClass(){
        class B{
            private final String name = "yae";

            public void show(){
                System.out.println("B name="+name);
                System.out.println("A name="+A.this.name);
            }
        }
        B b = new B();
        b.show();
    }
}
