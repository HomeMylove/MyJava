package com.neta.tankgame03;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
//            根据方向移动
            switch (getDirect()) {
                case 0:
                    if (getY() > 0)
                        moveUp();
                    else setDirect((int) (Math.random() * 4));
                    break;
                case 1:
                    if (getX() + 60 < 1000)
                        moveRight();
                    else setDirect((int) (Math.random() * 4));
                    break;
                case 2:
                    if (getY() + 60 < 750)
                        moveDown();
                    else setDirect((int) (Math.random() * 4));
                    break;
                case 3:
                    if (getX() > 0)
                        moveLeft();
                    else setDirect((int) (Math.random() * 4));
                    break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (Math.random() * 100 < 3) {
                setDirect((int) (Math.random() * 4));
            }
            if (!isLive) {
                break;
            }
        }
    }
}
