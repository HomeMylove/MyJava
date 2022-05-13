package com.neta.mystatic;

public class aboutblock {
    public static void main(String[] args) {
        Test test = new Test();

    }
}

class Sample{
    Sample(String s){
        System.out.println(s);                   //  (1) 静态成员sam初始化
    }
    Sample(){
        System.out.println("Sample默认构造函数被调用");
    }
}

class Test{
    Sample sam1 = new Sample("sam1成员初始化");         // (3) sam1成员初始化
    static Sample sam = new Sample("静态成员sam初始化");
    static {
        System.out.println("static块执行");             // (2) static块执行
        if(sam == null) System.out.println("sam is null");
    }
    Test(){
        System.out.println("Test默认构造函数被调用");         // (4) Test默认构造函数被调用
    }
}