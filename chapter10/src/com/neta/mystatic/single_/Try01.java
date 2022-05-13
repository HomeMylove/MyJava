package com.neta.mystatic.single_;

public class Try01 {
    public static void main(String[] args) {
        Person instance = Person.getInstance();
        Person instance1 = Person.getInstance();
        System.out.println(instance == instance1);
    }
}

class Person{
    private static Person person = new Person();

    private Person(){}

    public static Person getInstance(){
        return person;
    }
}
