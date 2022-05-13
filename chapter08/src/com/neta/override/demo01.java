package com.neta.override;

public class demo01 {
    public static void main(String[] args) {

    }
}


class Father{
    public Object show(){
        return null;
    }
}

class Son extends Father{
    public String show(){
        return "hello world";
    }
}
