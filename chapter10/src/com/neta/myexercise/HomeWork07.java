package com.neta.myexercise;

@SuppressWarnings({"all"})
public class HomeWork07 {
    public static void main(String[] args) {
        switch (Color.RED){
            case RED:
                System.out.println("这是红色");
                Color.RED.show();
        }
    }
}
@SuppressWarnings({"all"})
enum Color implements ShowColor {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("R=" + redValue + "\nG=" + greenValue + "\nB=" + blueValue);
    }
}


interface ShowColor {
    void show();
}
