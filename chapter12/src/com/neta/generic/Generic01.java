package com.neta.generic;

import java.util.ArrayList;

public class Generic01 {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        Dog wang = new Dog("Wang");
        Cat meow = new Cat("Meow");
        dogs.add(wang);
//        dogs.add(meow);
        ArrayList<Cat> cats = new ArrayList<>();

        for(Dog dog : dogs){
            System.out.println(dog);
        }
    }
}

class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }
}

class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }
}

