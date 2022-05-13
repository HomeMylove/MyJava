package com.neta.homework;

public class Homework02 {
    public static void main(String[] args) {
        Account account = new Account();
        Thread thread = new Thread(account);
        thread.setName("A");
        Thread thread1 = new Thread(account);
        thread1.setName("B");
        thread.start();

        thread1.start();
    }
}


class Account implements Runnable{
    private static int money = 10000;
//    private static final Object object = new Object();

    @Override
    public void run() {

            while (true){
                synchronized (this){
                    if(money < 1000){
                        System.out.println("余额不足");
                        break;
                    }
                    money -= 1000;
                    System.out.println("用户"+Thread.currentThread().getName()+"取款1000,剩余"+money+"元");
                }

                try {
                    int time = (int)Math.ceil(Math.random() *3);
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }




        }

        System.out.println("退出");
    }
}
