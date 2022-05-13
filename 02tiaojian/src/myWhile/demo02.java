package myWhile;

import java.util.Scanner;

public class demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char answer;
        do {
            System.out.println("还钱吗 y/n");
            answer = sc.next().charAt(0);
        } while (answer != 'y');
    }
}
