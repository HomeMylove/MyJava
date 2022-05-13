package com.neta.aboutEquals;

public class demo01 {
    public static void main(String[] args) {
        Person person = new Person("Yae", 500, '女');
        Person person1 = new Person("Yae", 500, '女');
        System.out.println(person);;

        System.out.println(person.equals(person1));
        person = null;
        System.gc();

    }
}
