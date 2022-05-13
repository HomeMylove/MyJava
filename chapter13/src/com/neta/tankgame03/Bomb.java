package com.neta.tankgame03;

public class Bomb {
    int x,y;
    int life = 9;  // 声明周期
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown(){
        if(life > 0){
            life--;
        }else{
            isLive = false;
        }
    }
}
