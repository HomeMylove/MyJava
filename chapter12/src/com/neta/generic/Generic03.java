package com.neta.generic;

import java.util.ArrayList;

public class Generic03 {
    public static void main(String[] args) {
        Person<A> person = new Person<>(new A());
        Person<A> aPerson = new Person<>(new B());
        Person<B> bPerson = new Person<>(new B());

        ArrayList arrayList = new ArrayList();
    }
}

class A{}
class B extends A{}

class Person<E>{
    E e;

    public Person(E e) {
        this.e = e;
    }
}
