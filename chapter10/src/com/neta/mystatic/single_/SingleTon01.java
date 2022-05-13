package com.neta.mystatic.single_;

public class SingleTon01 {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);
        GirlFriend instance1 = GirlFriend.getInstance();
        System.out.println(instance == instance1);
    }
}


class GirlFriend {
    private String name;
    private static GirlFriend gf = new GirlFriend("Yae");

    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance() {
        return gf;
    }
}