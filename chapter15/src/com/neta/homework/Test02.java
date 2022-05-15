package com.neta.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        File file = new File("E:\\dog.dat");
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Dog dog = (Dog) objectInputStream.readObject();
            System.out.println(dog);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
