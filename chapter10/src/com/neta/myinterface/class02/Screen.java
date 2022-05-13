package com.neta.myinterface.class02;

public class Screen implements  USB{
    @Override
    public void start() {
        System.out.println("Screen 开始工作");
    }

    @Override
    public void stop() {
        System.out.println("screen 停止工作");
    }
}
