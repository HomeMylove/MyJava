package com.neta.reflection_;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1. 获取 User 类的 Class 对象
        Class<?> userClass = Class.forName("com.neta.reflection_.User");
        // 2. 通过 public 无参构造器创建对象
        Object o1 = userClass.newInstance();
        System.out.println(o1);
        // 3. 通过 public 有参构造器创建对象
        Constructor<?> constructor1 = userClass.getConstructor(String.class, int.class);
        Object yae = constructor1.newInstance("Yae", 500);
        System.out.println(yae);
        // 4.通过 非public 的有参构造前创建对象
        Constructor<?> constructor2 = userClass.getDeclaredConstructor(String.class);
        constructor2.setAccessible(true);
        Object ei = constructor2.newInstance("Ei");
        System.out.println(ei);
    }
}


class User{
    private int age;
    private String name;

    public User(){};
    public User(String name,int age){
        this.name = name;
        this.age = age;
    };
    private User(String name){
        this.name = name;
    };

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
