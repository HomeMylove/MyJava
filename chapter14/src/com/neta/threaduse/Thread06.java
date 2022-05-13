package com.neta.threaduse;

public class Thread06 {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true){
                    System.out.println("hello");

                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    if(++count == 10){
//                        break;
                    }
                }
            }
        });

        for(int i = 0; i < 10; i++){
            System.out.println("hi");

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            if(i == 5){
                thread.start();
                thread.setDaemon(true);
//                thread.join();
            }
        }
    }
}

class ThreadExercise06 implements Runnable{

    @Override
    public void run() {
        int count = 0;
        while (true){
            System.out.println("hello");

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            if(++count == 10){
                break;
            }
        }

    }
}
