package com.neta.extend;

public class Student {
    public String name;
    public int age;
    public double score;
    private String school;

    public Student() {
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student(String name, int age, double score, String school) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.school = school;
    }

    public void testing(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
