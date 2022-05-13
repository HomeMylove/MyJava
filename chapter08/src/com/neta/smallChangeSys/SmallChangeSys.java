package com.neta.smallChangeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {

    // 先完成菜单
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key;

        // 明细
        String details = "----------零钱通明细----------";

        // 收益入账
        double money;
        double balance = 0;
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  // 用于日期格式化

        // 消费
        String note;
        do {
            System.out.println("======零钱通菜单=====");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退   出");

            System.out.println("请输入序号");
            key = scanner.next();

            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("收益入账金额");
                    money = scanner.nextDouble();
                    // 校验
                    // 判断不合理 退出
                    if (money <= 0) {
                        System.out.println("金额不能小于0");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.println("消费金额");
                    money = scanner.nextDouble();

                    if (money <= 0) {
                        System.out.println("金额不能小于0");
                        break;
                    }else if(money > balance){
                        System.out.println("没这么多钱");
                        break;
                    }

                    balance -= money;
                    System.out.println("消费原因");
                    note = scanner.next();

                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
                    System.out.println("退   出");
                    char answer;
                    do {
                        System.out.println("确定退出吗?y/n");
                        answer = scanner.next().charAt(0);
                    } while (answer != 'y' && answer != 'n');

                    if (answer == 'y') {
                        loop = false;  // 退出系统
                    }
                    break;
                default:
                    System.out.println("输入有误");
            }

        } while (loop);

        System.out.println("退出了项目~~~");
    }
}
