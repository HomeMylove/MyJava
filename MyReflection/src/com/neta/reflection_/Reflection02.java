package com.neta.reflection_;

public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 得到 Class 对象
        Class personClass = Class.forName("com.neta.reflection_.Person");
        // 获取全类名
        personClass.getName();  // com.neta.reflection_.Person
        personClass.getSimpleName();  // Person
        personClass.getDeclaredFields();
    }
}
class Animal{
    String hobby;
    public void hi(){};
}

class Person extends Animal{
    // 属性
    public String name;
    protected int age;
    String job;
    public double sal;
    // 方法
    public void m1(){};
    protected void m2(){};
    void m3(){};
    private void m4(){};
}
