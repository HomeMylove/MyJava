package com.neta;

public class mymath {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getRandomFromAtoB(1, 10));
        }
    }


    public static int getRandomFromAtoB(int a, int b) {
        return (int) (a + Math.random() * (b - a + 1));
    }
}
