package com.neta.tankgame03;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 绘图区域
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    // 定义我的坦克
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    // 存放炸弹
    // 子弹击中时加入一个bomb
    Vector<Bomb> bombs = new Vector<>();

    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    // 敌人数量
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100); // 初始化坦克
        hero.setSpeed(4);


        // 绘制敌人
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (1 + i), 0);
            enemyTank.setDirect(2);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);

        }
        // 加载炸弹
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.gif"));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);  // 填充

        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);

        int shotSize = 1;
        if (hero.shot != null && hero.shot.isLive) {
            g.fill3DRect(hero.shot.x - shotSize, hero.shot.y - shotSize, 2 * shotSize, 2 * shotSize, false);
        }
        // 如果有炸弹就画
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        // 画出敌人
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                // 画出子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
//                shotSize = 1;
                    if (shot.isLive) {
                        g.fill3DRect(shot.x - shotSize, shot.y - shotSize, 2 * shotSize, 2 * shotSize, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }


    }

    /**
     * 绘制坦克
     *
     * @param x      左上角x
     * @param y      右上角y
     * @param g      画笔
     * @param direct 方向（向下左右）
     * @param type   类型（敌我）
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 1: // 自己的坦克
                g.setColor(Color.cyan);
                break;
            case 0:  // 敌人的
                g.setColor(Color.yellow);
        }

        // 根据方向绘制
        switch (direct) {
            case 0: // 向上
                g.fill3DRect(x, y, 10, 60, false); //左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);// 右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);// 身体
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1: // 向右
                g.fill3DRect(x, y, 60, 10, false); //左边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);// 右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);// 身体
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;

            case 2: // 向下
                g.fill3DRect(x, y, 10, 60, false); //左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);// 右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);// 身体
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: // 向左
                g.fill3DRect(x, y, 60, 10, false); //左边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);// 右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);// 身体
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("没有处理");
        }
    }

    public void drawShot(int x, int y, Graphics g, int direct) {
        switch (direct) {
            case 0:
                g.drawLine(x, y, x, y - 10);
                break;
            case 1:
                g.drawLine(x, y, x + 10, y);
                break;
            case 2:
                g.drawLine(x, y, x, y + 10);
                break;
            case 3:
                g.drawLine(x, y, x - 10, y);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 判断我方子弹是否击中敌方坦克
    public void hitTank(Shot s, EnemyTank enemyTank) {
        switch (enemyTank.getDirect()) {
            case 0:
            case 2:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60
                ) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40
                ) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    // 处理 ASDW
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                hero.setDirect(0);
                if (hero.getY() > 0)
                    hero.moveUp();
                break;
            case KeyEvent.VK_S:
                hero.setDirect(2);
                if (hero.getY() + 60 < 750)
                    hero.moveDown();
                break;
            case KeyEvent.VK_A:
                hero.setDirect(3);
                if (hero.getX() > 0)
                    hero.moveLeft();
                break;
            case KeyEvent.VK_D:
                hero.setDirect(1);
                if (hero.getX() + 60 < 1000)
                    hero.moveRight();
                break;
            case KeyEvent.VK_J:
                hero.shotEnemy();
                break;
            default:
                break;
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 判断是否击中了敌人
            if (hero.shot != null && hero.shot.isLive) {

                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(hero.shot, enemyTank);
                }
            }


            this.repaint();
        }
    }
}
