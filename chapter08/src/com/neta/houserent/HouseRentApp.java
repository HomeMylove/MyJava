package com.neta.houserent;

import com.neta.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        // 创建HouseView对象显示主菜单
        new HouseView().mainMenu();
        System.out.println("==你退出了系统==");
    }
}
