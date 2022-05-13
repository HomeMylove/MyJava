package com.neta.homework;

public class Homework01 {
    public static void main(String[] args) {
        Animal[] arr = new Animal[3];
        arr[0] = new Animal("Yae",500,"miko");
        arr[1] = new Animal("Ganyu",200,"secret");
        arr[2] = new Animal("Venti",1000,"God");

        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length- i - 1;j++){
                if(arr[j].age<arr[j+1].age){
                    Animal temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i = 0;i< arr.length;i++){
            System.out.println(arr[i].name);
        }

    }
}

class Animal{
    String name;
    int age;
    String job;

    public Animal(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }
}
