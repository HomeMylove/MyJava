package com.neta.mystatic.single_;

public class SingleTon02 {
    public static void main(String[] args) {
        Cat instance = Cat.getInstance();
        Cat instance1 = Cat.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance == instance1);
    }
}

class Cat{
    private String name;
    private static Cat cat;

    private Cat(String name){
        this.name = name;
    }

    public static Cat getInstance(){
        if(cat == null){
            return new Cat("小猫咪");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
