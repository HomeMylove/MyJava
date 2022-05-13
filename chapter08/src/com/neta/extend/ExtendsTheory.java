package com.neta.extend;

public class ExtendsTheory{
    public static void main(String[] args){
        Son son = new Son();
        System.out.println(son.age);   // 40
        // 这时，要按照查找关系返回信息
        // (1) 首先查看子类是否有该属性
        // (2) 如果子类有这个属性，并且可以访问，则返回信息
        // (3) 如果子类没有这个属性，就看父类有没有这个属性（如果父类有该属性，并且可以访问，则返会信息)
        //(4) 如果父类没有这个属性，再按（3）的逻辑找，直到找到为止
    }
}

class GrandPa{
    String name = "Pappy";
    String hobby = "Dancing";
}

class Father extends GrandPa{
    String name = "Daddy";
    int age = 40;
}

class Son extends Father{
    String name = "Baby";
//    private int age = 10;
}