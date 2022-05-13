package com.neta.myinnerclass.anonymousclass;

public class AnonymousClassUse {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.test();
    }
}

class Computer{
    public void test(){
        handle(new USB() {
            @Override
            public void show() {
                System.out.println("我是一个显示器");
            }
        });
    }


    public void handle(USB usb){
        usb.show();
    }
}


interface USB{
    void show();
}
