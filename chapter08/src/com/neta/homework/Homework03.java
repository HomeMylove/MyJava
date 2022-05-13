package com.neta.homework;

public class Homework03 {
    public static void main(String[] args) {

    }
}

class Employee {
    private String name;
    private double perSal;
    private int day;
    private double grade;

    public Employee(String name, double perSal, int day, double grade) {
        this.name = name;
        this.perSal = perSal;
        this.day = day;
        this.grade = grade;
    }

    public void showSalary() {
        System.out.println("我的工资是" +(1000+ this.perSal * this.day * this.grade));
    }
}
