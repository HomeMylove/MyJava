package input;

import java.util.Scanner;

public class demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入姓名");
        String name = sc.nextLine();
        System.out.println("你是"+name+"对吧");
    }
}
