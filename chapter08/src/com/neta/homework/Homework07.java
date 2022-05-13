package com.neta.homework;

public class Homework07 {
    public static void main(String[] args) {
        GoodPerson goodStudent = new GoodStudent();
        goodStudent.eat();
        goodStudent.run();

        GoodStudent g = (GoodStudent) goodStudent;
        g.eat();
        g.run();
        g.study();
    }
}

class GoodPerson {
    public void run(){
        System.out.println("GoodPerson run");
    }
    public void eat(){
        System.out.println("GoodPerson eat");
    }
}

class GoodStudent extends GoodPerson{
    public void run(){
        System.out.println("Student run");
    }
    public void study(){
        System.out.println("Student study");
    }
}
