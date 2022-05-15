package com.neta.objetstream_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(100);
        oos.writeBoolean(true);
        oos.writeByte('a');
        oos.writeDouble(100.1);
        oos.writeUTF("窗前明月光");
        oos.writeObject(new Dog("旺财",10));
        oos.close();
        System.out.println("保存成功");
    }
}

class Dog implements Serializable{
    private String name;
    private int age = 1;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
