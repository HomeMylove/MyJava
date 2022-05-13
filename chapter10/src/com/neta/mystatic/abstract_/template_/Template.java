package com.neta.mystatic.abstract_.template_;

abstract public class Template {
    public void calculateTime(){
        long start = System.currentTimeMillis();

        job();

        long end = System.currentTimeMillis();
        System.out.println("这段代码用时"+(end-start)+"秒");
    }

    abstract public void job();
}
