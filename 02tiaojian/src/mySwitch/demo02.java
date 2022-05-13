package mySwitch;

import java.util.Scanner;

public class demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入分数");
        double score = sc.nextDouble();
        switch ((int)(score/60)){
            case 1:
                System.out.println("及格");
                break;
            case 0:
                System.out.println("不及格");
                break;
            default:
                System.out.println("错误");
        }
    }
}
