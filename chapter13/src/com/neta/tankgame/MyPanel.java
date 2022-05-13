package com.neta.tankgame;


import javax.swing.*;
import java.awt.*;

/**
 * 绘图区域
 */
public class MyPanel extends JPanel {
    // 定义我的坦克
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100,100); // 初始化坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);  // 填充

        drawTank(hero.getX(),hero.getY(),g,0,0);
    }

    /**
     * 绘制坦克
     * @param x 左上角x
     * @param y 右上角y
     * @param g 画笔
     * @param direct 方向（向下左右）
     * @param type 类型（敌我）
     */
    public void drawTank(int x,int y, Graphics g,int direct,int type){
        switch (type){
            case 0: // 自己的坦克
                g.setColor(Color.cyan);
                break;
            case 1:  // 敌人的
                g.setColor(Color.yellow);
        }

        // 根据方向绘制
        switch (direct){
            case 0: // 向上
                g.fill3DRect(x,y,10,60,false); //左边轮子
                g.fill3DRect(x+30,y,10,60,false);// 右边轮子
                g.fill3DRect(x+10,y+10,20,40,false);// 身体
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y);
                break;
            default:
                System.out.println("没有处理");
        }
    }
}
