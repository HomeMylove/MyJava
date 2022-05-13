package com.neta.houserent.service;

import com.neta.houserent.domain.House;

// 业务
public class HouseService {
    private House[] houses;
    private int houseNum = 1; // 记录当前有多少个房屋
    private int idCounter = 1;  // 记录自增长

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "Yae", "127", "Inazuma", 100, "已出租");
    }

    public House[] list() {
        return houses;
    }

    // 添加
    public boolean add(House house) {
//        判断是否可以继续添加
        if (houseNum == houses.length) {
            System.out.println("数组已满，不能添加");
            return false;
        }

        house.setId(++idCounter);
        houses[houseNum++] = house;

        return true;
    }

    // 删除
    public boolean del(int delId) {
        int id = -1;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null && houses[i].getId() == delId) {
                id = i;
                break;
            }
        }
        
        if(id == -1){
            System.out.println("没有房屋");
            return false;
        }else{

            for(int i = id; i < houseNum - 1; i++){
                houses[i] = houses[i+1];
            }
            houses[--houseNum] = null;
            return true;
        }
    }

    // 查找
    public House seek(int seekId){
        for(int i = 0; i < houseNum;i++){
            if(houses[i].getId() == seekId){
                return houses[i];
            }
        }
        return null;
    }



}
