package com.neta.homework;

public class Homework06 {
    public static void main(String[] args) {
        Doctor yae = new Doctor("Yae", 500, "miko", '女', 500);
        Doctor doctor = new Doctor("Ei", 500, "miko", '女', 500);
        System.out.println(yae.equals(doctor));
        doctor.setName("Yae");
        System.out.println(doctor.equals(yae));

    }
}


class Doctor{
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor() {
    }

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }else if(o instanceof Doctor){
            Doctor p = (Doctor) o;
            return p.name.equals(this.name)
                    && p.age == this.age
                    && p.job.equals(this.job)
                    && p.sal == this.sal
                    && p.gender == this.gender;

        }else {
            return false;
        }
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}
