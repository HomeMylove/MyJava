package com.neta.myexercise;

public class HomeWork05 {
    public static void main(String[] args) {
        Person yae = new Person("Yae", new Horse());
        yae.common();
        yae.passRiver();
        yae.common();
    }
}

interface Vehicles{
    void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("骑马走");
    }
}

class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("坐船走");
    }
}

class VehicleFactory{
    private static Horse horse = new Horse();

    private VehicleFactory(){};

    public static Horse getHorse(){
        return horse;
    }

    public static Boat getBoat(){
        return new Boat();
    }
}

class Person{
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver(){
        if(vehicles instanceof Horse){
        vehicles = VehicleFactory.getBoat();
        }
        vehicles.work();
    }

    public void common(){
        if(vehicles instanceof Boat){
            vehicles = VehicleFactory.getHorse();
        }
        vehicles.work();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }
}