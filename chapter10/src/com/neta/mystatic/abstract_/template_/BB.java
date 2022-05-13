package com.neta.mystatic.abstract_.template_;

public class BB extends Template{
    @Override
    public void job() {
        long num = 1;
        for(int i = 1; i < 20;i++){
            num *= i;
        }
        System.out.println("num="+num);
    }
}
