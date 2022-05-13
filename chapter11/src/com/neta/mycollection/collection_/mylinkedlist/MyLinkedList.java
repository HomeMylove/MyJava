package com.neta.mycollection.collection_.mylinkedlist;

public class MyLinkedList<E> {
    Node<E> first;
    Node<E> last;
    int size;

    public MyLinkedList(){
    }

    private static class Node<E>{
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev,E e,Node<E> next){
            this.item = e;
            this.prev = prev;
            this.next = next;
        }
    }

    public boolean add(E e){
        Node<E> l = last;
        Node<E> newNode = new Node<E>(l,e,null);
        last = newNode;
        if(first == null){
            first = newNode;
        }else{
            l.next = newNode;
        }

        size++;
        return true;
    }

    public E get(int index){
        Node<E> pointer = first;
        for(int i = 0; i < index; i++){
            pointer = pointer.next;
        }
        return pointer.item;
    }

    public boolean remove(int index){
        if(!(index >=0 && index < size)){
            throw new RuntimeException("错误的索引");
        }
        if(index == 0){
            return removeFirst();
        }else{
            Node<E> m = first;
            for(int i = 0; i < index; i++){
                m = m.next;
            }
            Node<E> prev = m.prev;
            Node<E> next = m.next;
            prev.next = next;
            next.prev = prev;
            m.prev = null;
            m.next = null;
            size--;
            return true;
        }

    }

    public boolean removeFirst(){
        if(size==0){
            return false;
        }
        Node<E> f = first;
        Node<E> next = f.next;
        f.item = null;
        f.next = null;
        if(next != null){
            next.prev = null;
            first = next;
        }
        size--;
        return true;
    }

}
