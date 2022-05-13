package com.neta.mystatic.single_;

public class Try02 {
    public static void main(String[] args) {
        Human instance = Human.getInstance();
        Human instance1 = Human.getInstance();
        System.out.println(instance == instance1);
    }
}

class Human{
    private static Human human;

    private Human(){}

    public static Human getInstance(){
        if(human == null){
            human =  new Human();
        }
        return human;
    }
}
