package com.neta.mystatic;

public class Main02 {
    public static void main(String[] args) {
        System.out.println(new Main02().name);
        new Main02().fn();

        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }

    public String name = "Yae";

    public void fn(){}
}
