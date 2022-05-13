package com.neta.houserent.view;

import com.neta.houserent.domain.House;
import com.neta.houserent.service.HouseService;
import com.neta.houserent.utils.Utility;

public class HouseView {
    private boolean loop = true;  // 控制显示
    private char key;  // 判断输入的序号
    private HouseService houseService = new HouseService(10);


    /**
     * 可以显示主菜单
     */
    public void mainMenu() {

        do {
            System.out.println("--------房屋出租系统-------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");
            System.out.println("请输入你的选择(1-6)");

            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    seekHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    editHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (loop);
    }

    /**
     * 显示房屋列表
     */
    public void listHouse() {
        System.out.println("==========房屋列表==========");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出租/未出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                continue;
            }
            System.out.println(houses[i]);
        }
    }

    // 接收输入创建House
    public void addHouse() {
        System.out.println("==========添加房屋==========");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态(已出租/未出租): ");
        String state = Utility.readString(8);

        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加房屋失败");
        }

    }

    public void deleteHouse() {
        System.out.println("==========删除房屋==========");
        System.out.println("请输入要删除的房屋编号(-1退出)");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("你放弃了删除");
            return;
        }
        // 本来就有循环判断的逻辑
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } else {
            System.out.println("你放弃了删除");
        }

    }

    public void exit(){
        char c = Utility.readConfirmSelection();
        if(c == 'Y'){
            loop = false;
        }
    }

    public void seekHouse(){
        System.out.println("==========查找房屋==========");
        System.out.println("请输入要查找的房屋编号(-1退出)");
        int seekId = Utility.readInt();
        if(seekId == -1){
            System.out.println("退出了查找");
        }else{
            if(houseService.seek(seekId) != null){
                System.out.println("==========房屋信息==========");
                System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出租/未出租)");
                System.out.println(houseService.seek(seekId));
            }else{
                System.out.println("不存在的房屋");
            }
        }
    }

    public void editHouse(){
        System.out.println("==========修改房屋==========");
        System.out.println("请输入要修改的房屋编号(-1退出)");
        int editId = Utility.readInt();
        if(editId == -1){
            System.out.println("推出了修改");
        }else{
            House seek = houseService.seek(editId);
            if(seek == null){
                System.out.println("不存在的房屋");
                return;
            }

            System.out.println("姓名:("+seek.getName()+")");
            String name= Utility.readString(8,"");
            if(!name.equals("")){
                seek.setName(name);
            }
            System.out.println("电话:("+seek.getPhone()+")");
            String phone= Utility.readString(12,"");
            if(!phone.equals("")){
                seek.setPhone(phone);
            }
            System.out.println("地址:("+seek.getAddress()+")");
            String address= Utility.readString(16,"");
            if(!address.equals("")){
                seek.setAddress(address);
            }
            System.out.println("月租:("+seek.getRent()+")");
            int rent = Utility.readInt(0);
            if(rent == 0){
                seek.setRent(rent);
            }
            System.out.println("状态:("+seek.getState()+")");
            String state= Utility.readString(8,"");
            if(!state.equals("")){
                seek.setState(state);
            }
        }
    }
}
