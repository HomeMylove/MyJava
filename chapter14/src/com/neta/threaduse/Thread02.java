package com.neta.threaduse;

public class Thread02 {
    public static void main(String[] args)throws InterruptedException {
        Dog dog = new Dog();
//        Thread thread = new Thread(dog);
//        thread.start();

        ThreadProxy threadProxy = new ThreadProxy(dog);
        threadProxy.start();
    }
}
class ThreadProxy implements Runnable{
    Runnable runnable = null;
    public ThreadProxy(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        runnable.run();
    }

    public void start(){
        start0();
    }

    public void start0(){
        run();
    }
}

class Dog implements Runnable{
    int count = 0;

    @Override
    public void run() {
        while (true){
            System.out.println("小狗汪汪叫"+ ++count + "线程"+Thread.currentThread().getName());

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            if(count == 10){
                break;
            }
        }
    }
}
