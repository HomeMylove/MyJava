package com.neta.homework;

public class Homework05 {
    public static void main(String[] args) {

    }
}

class Point{
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class LabeledPoint extends Point{
    String label;

    public LabeledPoint(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }
}
