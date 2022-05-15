package com.neta.homework;

import java.io.*;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        Properties properties = new Properties();
        File file = new File("E:\\dog.properties");
        File file1 = new File("E:\\dog.dat");
        ObjectOutputStream objectOutputStream = null;


        try {
            properties.load(new FileReader(file));
            Dog dog = new Dog(
                    properties.getProperty("name"),
                    Integer.parseInt(properties.getProperty("age")),
                    properties.getProperty("color")
            );
            System.out.println(dog);

//            序列化输出
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file1));
            objectOutputStream.writeObject(dog);
            objectOutputStream.close();
            System.out.println("保存成功");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
