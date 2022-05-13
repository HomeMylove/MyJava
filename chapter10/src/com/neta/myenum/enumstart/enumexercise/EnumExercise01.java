package com.neta.myenum.enumstart.enumexercise;

public class EnumExercise01 {
    public static void main(String[] args) {
        Week[] values = Week.values();
        for(Week week : values){
            System.out.println(week);
        }

    }
}

enum Week{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}

abstract class Animal{
    public abstract void cry();
}

class Cat extends Animal{
//    @Override
    public int cry(int a) {
        return a;
    }

    public void cry(){}
}
