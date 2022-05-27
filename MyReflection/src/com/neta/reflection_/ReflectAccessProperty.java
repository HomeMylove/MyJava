package com.neta.reflection_;

import java.lang.reflect.Field;

public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获取 Student 类的 Class 对象
        Class<?> studentClass = Class.forName("com.neta.reflection_.Student");
        // 获取实例
        Object o = studentClass.newInstance();
        // 获取 age 属性对象
        Field age = studentClass.getField("age");
        age.set(o,18);
        System.out.println(o);
        // 获取 name 属性对象
        Field name = studentClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"Yae");
        System.out.println(o);

        Field money = studentClass.getDeclaredField("money");
        money.setAccessible(true);
        money.set(null,100.0);

    }
}

class Student{
    public int age;
    private String name;
    private static double money;

    public Student(){}
    public Student(String name){}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
