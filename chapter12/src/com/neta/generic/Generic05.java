package com.neta.generic;

public class Generic05 {
    public static void main(String[] args) {
        MyGeneric<Double, String, Integer> g = new MyGeneric<Double, String, Integer>("John");
    }
}

class MyGeneric<K,T,V>{
    K k;
    T t;
    V v;

    public MyGeneric(T t) {
        this.t = t;
    }




}
