package com.neta.myinnerclass.localinnerclass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.m1();
    }
}

class Outer{
    private int n1 = 400;
    public void m2(){}
    public void m1(){
        class InnerClass{
            public int n1 = 300;
            public void f1(){
                int n1 = 100;
                System.out.println("内部类方法"+n1);
                System.out.println("内部类属性"+this.n1);
                System.out.println("外部类属性"+Outer.this.n1);
                m2();
            }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.f1();
    }
}
