package com.neta.mystatic.abstract_;

abstract public class Animal {
    public static void main(String[] args) {

    }
}

abstract class A{
    abstract public void fn();
}

class B extends A{
    @Override
    public void fn() {
        //...
    }
}

abstract class C extends A{

}
