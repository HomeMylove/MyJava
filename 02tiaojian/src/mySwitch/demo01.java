package mySwitch;

import java.util.Scanner;

public class demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个小写字母");
        char letter = sc.nextLine().charAt(0);
        switch (letter){
            case 'a':
                System.out.println('A');
                break;
            case 'b':
                System.out.println('B');
                break;
            case 'c':
                System.out.println('C');
                break;
            case 'd':
                System.out.println('D');
                break;
            case 'e':
                System.out.println('E');
                break;
            default:
                System.out.println("other");
                break;
        }
    }
}
