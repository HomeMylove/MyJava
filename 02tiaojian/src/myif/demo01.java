package myif;

import java.util.Scanner;

public class demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int secret = (int) (Math.random() * 100);
        System.out.println(secret);
        int count = 6;
        int guess;
        while (count > 0) {
            System.out.println("请猜一个数");
            guess = Integer.parseInt(sc.nextLine());
            if (guess > secret) {
                System.out.println("大了,还有" + --count + "次机会");
            } else if (guess < secret) {
                System.out.println("小了,还有" + --count + "次机会");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
    }
}
