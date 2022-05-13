package com.neta.tankgame;

import javax.swing.*;

public class TankGame extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame();
    }

    public TankGame(){
        mp = new MyPanel();
        this.add(mp);  // 把面板加进去
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
