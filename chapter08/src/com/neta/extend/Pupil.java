package com.neta.extend;

public class Pupil extends Student{

    public Pupil() {
    }

    public Pupil(String name, int age, double score, String school) {
        super(name, age, score, school);
    }


    @Override
    public void testing() {
        System.out.println("小学生考试");
    }

    public void show(){
        System.out.println(getSchool());
    }
}
