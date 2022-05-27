package com.neta.reflection_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionQuestion {
    public static void main(String[] args) throws InvocationTargetException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String classsfullpath = "Cat";
        String methodName = "hi";

//        加载类，返回Class类型的对象cls
        Class cls = Class.forName(classsfullpath);
//        通过 cls 可以创建加载的类 Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass());  // class Cat
//        获取名为 “hi” 的方法对象
        Method method = cls.getMethod(methodName);
//        通过 “方法对象” 调用方法
        method.invoke(o);

        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;

        Class<Integer> type = Integer.TYPE;
    }
}
