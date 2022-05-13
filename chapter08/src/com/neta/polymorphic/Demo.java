package com.neta.polymorphic;

class Animal{
    public void cry(){
        System.out.println("动物叫~~");
        A a = new B();
        System.out.println(a instanceof B);  // true
        System.out.println(a instanceof A);  // true
    }
}

class Cat extends Animal{
    public void catchMouse(){
        System.out.println("猫捉老鼠~~");
    }
}

public class Demo{
    public static void main(String[] args){
        Animal animal = new Cat();
        animal.cry();   // 动物叫~~
//        animal.catchMouse();   // 报错
        Cat cat = (Cat) animal;

        cat.catchMouse();
    }
}

class A{}
class B extends A{}
