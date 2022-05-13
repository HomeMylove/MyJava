package com.neta.myinterface.class02;

public class Test {
    public static void main(String[] args) {
        Camera camera = new Camera();
        Screen screen = new Screen();
        Computer(camera);
        Computer(screen);
        USB[] usbs = new USB[2];
        usbs[0] = camera;
        usbs[1] = screen;
    }

    public static void Computer(USB usb){
        usb.start();
        usb.stop();
    }
}
