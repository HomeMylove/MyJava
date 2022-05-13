package com.neta.mycollection.collection_.mylinkedlist;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        for(int i = 0; i < 10; i++){
            myLinkedList.add(i);
        }

        System.out.println(myLinkedList.get(5));
        myLinkedList.removeFirst();
        myLinkedList.remove(7);
        System.out.println(myLinkedList.get(7));


    }
}
