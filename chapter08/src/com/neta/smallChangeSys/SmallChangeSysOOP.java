package com.neta.smallChangeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 完成功能
 */
public class SmallChangeSysOOP {
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
    /**
     * 显示菜单
     */
    public void mainMenu(){
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
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误");
            }

        } while (loop);

        System.out.println("退出了系统");
    }

    public void detail(){
        System.out.println(details);
    }

    public void income(){
        System.out.println("收益入账金额");
        money = scanner.nextDouble();
        // 校验
        // 判断不合理 退出
        if (money <= 0) {
            System.out.println("金额不能小于0");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    public void pay(){
        System.out.println("消费金额");
        money = scanner.nextDouble();

        if (money <= 0) {
            System.out.println("金额不能小于0");
            return;
        }else if(money > balance){
            System.out.println("没这么多钱");
            return;
        }

        balance -= money;
        System.out.println("消费原因");
        note = scanner.next();

        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;

    }

    public void exit(){
        System.out.println("退   出");
        char answer;
        do {
            System.out.println("确定退出吗?y/n");
            answer = scanner.next().charAt(0);
        } while (answer != 'y' && answer != 'n');

        if (answer == 'y') {
            loop = false;  // 退出系统
        }
    }

}
