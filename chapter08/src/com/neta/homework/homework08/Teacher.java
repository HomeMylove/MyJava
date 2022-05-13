package com.neta.homework.homework08;

public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, int age, char gender, int work_age) {
        super(name, age, gender);
        this.work_age = work_age;
    }

    @Override
    public String basicInfo() {
        return super.basicInfo()+"\n教龄:"+this.work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会认真教学");
    }

    @Override
    public String play() {
        return super.play() + "象棋";
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }
}
