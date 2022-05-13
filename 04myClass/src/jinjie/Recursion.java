package jinjie;

public class Recursion {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(febo(i));
        }

        System.out.println("第1天有" + peach(1));
    }


    public static int febo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return febo(n - 1) + febo(n - 2);
        }
    }

    public static int peach(int day) {
        if (day == 10) {
            return 1;
        } else if(day>0 && day < 10){
            return 2 * (peach(day + 1) + 1);
        }else{
            System.out.println("索引错误1-10");
            return -1;
        }
    }
}

