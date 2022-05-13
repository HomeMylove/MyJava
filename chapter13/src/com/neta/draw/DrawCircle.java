package com.neta.draw;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"all"})
public class DrawCircle extends JFrame{
    // 可以理解成一个画框
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){
        // 初始化画板
        mp = new MyPanel();
        // 把画板放入窗口
        this.add(mp);
        // 设置窗口大小
        this.setSize(800,600);
        // 当点击窗口小×，退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}

// 在这个面板上画
class MyPanel extends JPanel{

    // 说明
    // MyPanel 就是一个画板
    // g 就是一支画笔
    // paint 调用时机
        // 窗口最小化，再最大化
        // 窗口大小变化
        // repaint 函数调用
    @Override
    public void paint(Graphics g) {
        super.paint(g);  // 调用父类的方法完成初始化
        g.drawOval(50,50,200,200);

        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bg.jpg"));
        g.drawImage(image,0,0,768,432,this);
//        System.out.println(image);
    }


}
