package com.neta.tankgame02;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 绘图区域
 */
public class MyPanel extends JPanel implements KeyListener {
    // 定义我的坦克
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    // 敌人数量
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100,100); // 初始化坦克
        hero.setSpeed(4);

        for(int i = 0; i < enemyTankSize; i++){
            EnemyTank enemyTank = new EnemyTank(100 * (1 + i), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);  // 填充

        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);

        // 画出敌人
        for(int i = 0; i< enemyTanks.size(); i++){
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
        }
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
            case 1: // 自己的坦克
                g.setColor(Color.cyan);
                break;
            case 0:  // 敌人的
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
            case 1: // 向右
                g.fill3DRect(x,y,60,10,false); //左边轮子
                g.fill3DRect(x,y+30,60,10,false);// 右边轮子
                g.fill3DRect(x+10,y+10,40,20,false);// 身体
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x+60,y+20);
                break;

            case 2: // 向下
                g.fill3DRect(x,y,10,60,false); //左边轮子
                g.fill3DRect(x+30,y,10,60,false);// 右边轮子
                g.fill3DRect(x+10,y+10,20,40,false);// 身体
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3: // 向左
                g.fill3DRect(x,y,60,10,false); //左边轮子
                g.fill3DRect(x,y+30,60,10,false);// 右边轮子
                g.fill3DRect(x+10,y+10,40,20,false);// 身体
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x,y+20);
                break;
            default:
                System.out.println("没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 处理 ASDW
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                hero.setDirect(0);
                hero.moveUp();
                break;
            case KeyEvent.VK_S:
                hero.setDirect(2);
                hero.moveDown();
                break;
            case KeyEvent.VK_A:
                hero.setDirect(3);
                hero.moveLeft();
                break;
            case KeyEvent.VK_D:
                hero.setDirect(1);
                hero.moveRight();
                break;
            default:
                break;
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
