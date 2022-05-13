package com.neta.encap;

public class Account {
    private String name;
    private double money;
    private String password;

    public Account() {
    }

    public Account(String name, double money, String password) {
        setName(name);
        setMoney(money);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()>=2 && name.length()<=4){
            this.name = name;
        }else{
            System.out.println("名字应为3-4位");
            this.name = "Tom";
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if(money >= 20){
            this.money = money;
        }else{
            System.out.println("余额应该大于20");
            this.money = 20;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length()==6){
            this.password = password;
        }else{
            System.out.println("密码必须是6位,已设置默认000000");
            this.password = "000000";
        }
    }

    public void show(){
        System.out.println("Name: "+this.name);
        System.out.println("money: "+this.money);
        System.out.println("password: "+this.password);
    }
}
