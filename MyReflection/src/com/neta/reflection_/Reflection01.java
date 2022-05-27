package com.neta.reflection_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Reflection01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入key:");
        String key = scanner.next();
        switch (key){
            case "1":
//                Dog dog = new Dog();
//                dog.cry();
                break;
            case "2":
                Class cls = Class.forName("Dog");
                Object o = cls.newInstance();
                Method method = cls.getMethod("cry");
                method.invoke(o);
                break;
            default:
                break;
        }
    }
}
