package com.neta.reflection_;

import java.lang.reflect.Field;

public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<?> cls = Class.forName("com.neta.reflection_.PrivateTest");
        PrivateTest o = (PrivateTest)cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"Yae");
        System.out.println(o.getName());
    }
}

class PrivateTest{
    private String name = "Hello Kitty";

    public String getName() {
        return name;
    }
}
