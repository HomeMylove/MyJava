package com.neta.homework.homework08;

public class Student extends Person {
    private int stu_id;

    public Student(String name, int age, char gender, int stu_id) {
        super(name, age, gender);
        this.stu_id = stu_id;
    }

    @Override
    public String basicInfo() {
        return super.basicInfo() + "学号:" + this.stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }
}
