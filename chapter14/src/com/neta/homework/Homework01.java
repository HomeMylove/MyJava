package com.neta.homework;

import java.util.Locale;
import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        Thread thread = new Thread(threadA);
        thread.start();
        thread.setName("线程A");

        ThreadB threadB = new ThreadB(threadA);
        Thread thread1 = new Thread(threadB);
        thread1.start();
        thread1.setName("线程B");

    }
}

class ThreadA implements Runnable {
    private int count = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println(count++ % 100);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程" + Thread.currentThread().getName() + "结束");
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}


class ThreadB implements Runnable {
    private final Scanner scanner = new Scanner(System.in);
    private ThreadA threadA = null;

    public ThreadB(ThreadA threadA) {
        this.threadA = threadA;
    }

    @Override
    public void run() {

        System.out.println("输入一个值");
        char c = scanner.next().toUpperCase(Locale.ROOT).charAt(0);

        if (c == 'Q') {

            threadA.setLoop(false);

        }

        System.out.println("线程" + Thread.currentThread().getName() + "结束");
    }
}