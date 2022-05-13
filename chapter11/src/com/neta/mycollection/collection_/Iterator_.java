package com.neta.mycollection.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Iterator_ {
    public static void main(String[] args) {
        Collection books = new ArrayList<>();

        Book yae = new Book("Yae", 12.0,"hodaru");
        Book ei = new Book("Ei", 90.0,"lumine");
        Book kokomi = new Book("kokomi", 120.99,"zora");

        books.add(yae);
        books.add(ei);
        books.add(kokomi);

        Iterator iterator = books.iterator();

        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("the book is"+obj);
        }


    }
}


class Book{
    private String name;
    private double price;
    private String author;

    public Book(String name, double price,String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "名称:" + name + '\t' + "价格:" + price + '\t' + "作者:" + author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}