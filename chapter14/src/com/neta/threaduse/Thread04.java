package com.neta.threaduse;

public class Thread04 {
    public static void main(String[] args) throws InterruptedException{
        Test01 test01 = new Test01();
        Thread thread = new Thread(test01);

        thread.start();
        // 休眠十秒
        System.out.println("开始休眠");
        Thread.sleep(10* 1000);
        test01.setLoop(false);
        System.out.println("主线程结束");
    }
}

class Test01 implements Runnable {
    private int count;
    private boolean loop = true;

    @Override
    public void run() {

        while (loop) {
            System.out.println("这里是" + ++count + "线程" + Thread.currentThread().getName());

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("退出线程");

    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
