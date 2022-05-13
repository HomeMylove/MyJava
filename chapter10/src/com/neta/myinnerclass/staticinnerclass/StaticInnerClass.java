package com.neta.myinnerclass.staticinnerclass;

public class StaticInnerClass {
    public static void main(String[] args){
//        Outer.Inner inner = new Outer.Inner();
        Outer.Inner staticInnerClass = new Outer().getStaticInnerClass();
        staticInnerClass.say();
    }
}

class Outer{
    private int age = 10;
    private static String name = "yae";
    public static class Inner{
        public static String name = "ei";
        public void say(){
            System.out.println("inner static class "+name+Outer.name);
        }
    }

    public Inner getStaticInnerClass(){
        return new Inner();
    }
}
