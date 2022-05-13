package com.neta.mystatic.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(2.0);
        System.out.println("面积是"+circle.countArea());
    }
}

class Circle{
    private double radius;
    private final double PI ;
    {
        PI = 3.14;
    }

    public Circle(double radius) {
        this.radius = radius;

    }
    public double countArea(){
        return PI * radius * radius;
    }
}
