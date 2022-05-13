package com.neta.myinnerclass.memberinnerclass;

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();

        Outer.Inner inner =outer.new Inner();
        Outer.Inner innerInstance = outer.getInnerInstance();
    }
}

class Outer{
    private int n1 = 10;
    public String name = "张三";
    class Inner{
        public void say(){
            System.out.println("我是成员内部类");
        }
    }

    public void test(){
        Inner inner = new Inner();
        inner.say();
    }

    public Inner getInnerInstance(){
        return new Inner();
    }
}
