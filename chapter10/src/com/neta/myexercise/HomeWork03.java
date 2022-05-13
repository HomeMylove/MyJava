package com.neta.myexercise;

public class HomeWork03 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();

        cellPhone.testWork(new Calculator() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },10,20);
    }
}

interface Calculator{
    double work(double n1,double n2);
}

class CellPhone {
    public void testWork(Calculator calculator,double n1,double n2){
        double result = calculator.work(n1, n2);
        System.out.println("结果是"+result);
    }
}
