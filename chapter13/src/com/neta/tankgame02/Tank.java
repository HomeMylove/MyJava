package com.neta.tankgame02;

public class Tank {
    private int x;  // 横坐标
    private int y;  // 纵坐标
    private int direct; // 方向
    private int speed = 1;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;

    }

    // 移动方法
    public void moveUp(){
        y -= speed;
    }

    public void moveDown(){
        y += speed;
    }

    public void moveLeft(){
        x -= speed;
    }

    public void moveRight(){
        x += speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
