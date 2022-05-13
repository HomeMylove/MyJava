package com.neta.threaduse;

public class MySynchronized {
    public static void main(String[] args) {
        Thread thread = new Thread(new SynchronizedThread());
        Thread thread1 = new Thread(new SynchronizedThread());
        Thread thread2 = new Thread(new SynchronizedThread());

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class SynchronizedThread implements Runnable{
    static int i = 100;
    private boolean loop = true;

    public synchronized void sell(){
        if(i <= 0){
            loop = false;
            return;
        }
        System.out.println("线程"+Thread.currentThread().getName()+"i="+i--);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (loop){
            sell();
        }
        System.out.println("停止");
    }
}


