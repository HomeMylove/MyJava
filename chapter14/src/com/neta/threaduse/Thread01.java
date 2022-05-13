package com.neta.threaduse;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();   // 可以当作线程使用
        cat.start();  // 启动线程


        for(int i = 0; i<80; i++){
            System.out.println("主线程"+ i);
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("我是一只猫" + i++ +"线程名="+ Thread.currentThread());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i == 80) {
                break;
            }
        }
    }
}
