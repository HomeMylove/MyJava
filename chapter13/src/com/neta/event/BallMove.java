package com.neta.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 演示小球通过控制上下左右移动
 */
public class BallMove extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp); // 监听面板发生的事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

// KeyListener 监听器
class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }


    // 有字符输出
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 按下按键
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                y--;
                break;
            case KeyEvent.VK_S:
                y++;
                break;
            case KeyEvent.VK_A:
                x--;
                break;
            case KeyEvent.VK_D:
                x++;
                break;
            default:
                break;
        }

        this.repaint();

    }

    // 松开按键
    @Override
    public void keyReleased(KeyEvent e) {

    }
}