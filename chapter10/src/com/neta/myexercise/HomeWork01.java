package com.neta.myexercise;

public class HomeWork01 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock = new Frock();
        System.out.println(frock.getSerialNumber());
        Frock frock1 = new Frock();
        System.out.println(frock1.getSerialNumber());
        Frock frock2 = new Frock();
        System.out.println(frock2.getSerialNumber());
    }
}

class Frock{
    private static int currentNum = 100000;
    private final int serialNumber;

    public Frock(){

        this.serialNumber =  getNextNum();
    }

    public static int getNextNum(){
        currentNum += 100;
        return currentNum;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

}
