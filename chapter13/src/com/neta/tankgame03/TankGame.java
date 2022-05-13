package com.neta.tankgame03;

import javax.swing.*;

public class TankGame extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame();
    }

    public TankGame(){
        mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);  // 把面板加进去
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
