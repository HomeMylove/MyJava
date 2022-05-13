package com.neta.threaduse;

public class Thread03 {
    public static void main(String[] args) {
        Person0 person0 = new Person0("Hello World", 10);
        Person0 person1 = new Person0("Hi", 5);

        Thread thread = new Thread(person0);
        Thread thread1 = new Thread(person1);

        thread.start();
        thread1.start();
    }
}

class Person0 implements Runnable{
    private String word;
    private int count;

    public Person0(String word,int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public void run() {
        int i = 0;

        while (true){
            System.out.println(word+"次数="+ ++i +" 线程="+Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(i == count){
                break;
            }
        }
    }
}
