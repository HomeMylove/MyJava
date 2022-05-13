package com.neta.extend;

public class Exercise {
    public static void main(String[] args) {
        PC pc = new PC("2g", "256g", "d", "huawei");
        NotePad notePad = new NotePad("10g", "64g", "c", "yellow");
        pc.getDetails();
        System.out.println("=====");
        notePad.getDetails();

    }
}

class Computer{
    String cpu;
    String memory;
    String disk;

    public Computer() {
    }

    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public void getDetails(){
        System.out.println("cpu:\t"+this.cpu);
        System.out.println("memory\t"+this.memory);
        System.out.println("disk\t"+this.disk);
    }
}

class PC extends Computer{
    String brand;
    public PC() {
    }

    public PC(String cpu, String memory, String disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    public void getDetails(){
        super.getDetails();
        System.out.println("brand\t"+this.brand);
    }
}

class NotePad extends Computer{
    String color;

    public NotePad(){}

    public NotePad(String cpu, String memory, String disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }

    public void getDetails(){
        super.getDetails();
        System.out.println("color\t"+this.color);
    }
}
