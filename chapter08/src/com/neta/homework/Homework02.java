package com.neta.homework;

public class Homework02 {
    public static void main(String[] args) {
        Professor yae = new Professor("Yae", 500, "Miko", 900, 1.3);
        System.out.println(yae.introduce());
    }
}


class Teacher{
    private String name;
    private int age;
    private String post;
    private double salary;
    private double grade;

    public Teacher(String name, int age, String post, double salary,double grade) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.grade = grade;
    }

    public String introduce(){
        return "姓名:"+this.name+"\t年龄:"+this.age+"\t职称:"+this.post+"\t基本工资:"+this.salary;
    }
}

class Professor extends Teacher{
    private double salary;
    private double grade;
    public Professor(String name, int age, String post, double salary,double grade) {
        super(name, age, post, salary,grade);
        this.salary = salary;
        this.grade = grade;
    }

    @Override
    public String introduce() {
        return super.introduce()+"\t实际工资"+this.salary*this.grade;
    }
}
