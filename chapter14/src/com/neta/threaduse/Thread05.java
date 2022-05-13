package com.neta.threaduse;

public class Thread05 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new T());
        thread.start();
        for(int i = 0; i < 20; i++){
            System.out.println("主线程"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(i == 5){
                System.out.println("让子线程先执行完毕");
                thread.join();
                System.out.println("子线程完毕，主线程开始");
            }
        }
    }
}

class T implements Runnable{
    private int i ;

    @Override
    public void run() {
        while (true){
            System.out.println("子线程"+ ++i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 20){
                break;
            }
        }
    }
}
