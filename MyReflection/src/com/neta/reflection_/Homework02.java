package com.neta.reflection_;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
        Class<?> fileClass = Class.forName("java.io.File");

        Constructor<?>[] constructors = fileClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println("File的构造器="+constructor);
        }

        Constructor<?> constructor = fileClass.getConstructor(String.class);
        File file = (File) constructor.newInstance("E:\\aa.txt");
        file.createNewFile();


    }
}

