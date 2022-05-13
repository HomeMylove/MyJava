package com.neta.myexercise;

public class HomeWork06 {
    public static void main(String[] args) {
        Car car = new Car(41.0);
        car.getAir().flow();

        Car car1 = new Car(10);
        Car.Air air1 = car1.new Air();
        air1.flow();
    }
}

class Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }
    class Air{
        public void flow(){
            if(temperature > 40){
                System.out.println("吹冷气");
            }else if(temperature < 0){
                System.out.println("吹暖气");
            }else{
                System.out.println("空调关闭");
            }
        }
    }

    public Air getAir(){
        return new Air();
    }
}
