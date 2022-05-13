package com.neta.debug;

public class Person extends Animal{
    private String hobby;
    public Person(){}
    public Person(String name,int age,String hobby){
        super(name,age);
        setHobby(hobby);
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }
}



