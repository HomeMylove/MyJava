package com.neta.override;

public class OverrideExercise {
    public static void main(String[] args) {
        Person yae = new Person("Yae",500);
        Student ei = new Student("Ei", 300, 2019, 89.5);

        System.out.println(yae.say());
        System.out.println(ei.say());
    }
}


class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.setAge(age);
        this.setName(name);
    }

    public String say(){
        return "I'm "+this.name + "\nI'm "+ this.age + " years old.\n";
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
}

class Student extends Person{
    private int id;
    private double score;

    public Student() {
    }

    public Student(String name, int age, int id, double score) {
        super(name, age);
        this.setId(id);
        this.setScore(score);
    }

    @Override
    public String say() {
        return super.say() + "My id is "+this.id+"\n"+"My score is "+this.score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}