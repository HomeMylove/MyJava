package jinjie;

public class demo01 {
    public static void main(String[] args) {

        hanoi(3,'A','B','C');

    }

    public static void move(char a,char b){
        System.out.println(a + "-->" + b);
    }

    public static void hanoi(int n, char barA, char barB, char barC) {
        if (n == 1) {
            move(barA,barC);
        }else{
            hanoi(n-1,barA,barC,barB);
            move(barA,barC);
            hanoi(n-1,barB,barA,barC);
        }
    }
}

