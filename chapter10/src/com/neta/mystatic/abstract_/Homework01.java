package com.neta.mystatic.abstract_;

public class Homework01 {
    public static void main(String[] args) {
        CommonEmployee yae = new CommonEmployee("yae", 110, 2000.0);
        Manager ei = new Manager("ei", 120, 100, 3000.0);
        System.out.println(yae.introduce());
        System.out.println(ei.introduce());
        System.out.println(yae.work());
        System.out.println(ei.work());
    }
}

abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    abstract public String work();

    abstract public String introduce();
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public String work() {
        return "员工 " + getName() + " 工作中...";
    }

    @Override
    public String introduce() {
        return "我叫" + getName() + ",id是" + getId() + ",薪水是" + getSalary() + "元，没有奖金";
    }
}

class Manager extends Employee {
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public String work() {
        return "经理 " + getName() + " 工作中...";
    }

    @Override
    public String introduce() {
        return "我叫" + getName() + ",id是" + getId() + ",薪水是" + getSalary() + "元，奖金" + getBonus() + "元";
    }
}

