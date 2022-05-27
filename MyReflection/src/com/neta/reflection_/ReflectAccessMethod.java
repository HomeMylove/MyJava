package com.neta.reflection_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1. 获取 Teacher 类的 Class 对象
        Class<?> teacherClass = Class.forName("com.neta.reflection_.Teacher");
        // 2. 创建对象
        Object o = teacherClass.newInstance();
        // 3.获取 hi 方法
        Method hi = teacherClass.getMethod("hi");
        hi.invoke(o);   // hi~
        // 4.获取 hello 方法
        Method hello = teacherClass.getDeclaredMethod("hello", String.class);
        hello.setAccessible(true);
        hello.invoke(null,"Ei");  // I'm Yae, hello~,Ei
    }
}

class Teacher{
    private static String name = "Yae";

    public Teacher(){}

    public void hi(){
        System.out.println("hi~");
    }
    private static void hello(String name){
        System.out.println("I'm "+ Teacher.name+", hello~," + name);
    }
}
