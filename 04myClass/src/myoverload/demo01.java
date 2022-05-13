package myoverload;

public class demo01 {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.calculate(1,2.9));
        System.out.println(cal.calculate(1,9,100));


    }
}


class Calculator{
    public int calculate(int n1,int n2){
        return n1 + n2;
    }

    public double calculate(int n1,double n2){
        return n1 + n2;
    }

    public double calculate(double n1,int n2){
        return n1 + n2;
    }

    public int calculate(int n1,int n2,int n3){
        return n1 + n2 + n3;
    }
}



