package com.neta.myinterface.class02;

public class Camera implements USB {
    @Override
    public void start() {
        System.out.println("camera 开始工作");
    }

    @Override
    public void stop() {
        System.out.println("camera 停止工作");
    }
}
