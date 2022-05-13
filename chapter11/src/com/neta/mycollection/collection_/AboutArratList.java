package com.neta.mycollection.collection_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class AboutArratList {
    public static void main(String[] args) {

        LinkedList<Object> objects = new LinkedList<>();

        for(int i = 0; i < 10; i++){
            objects.add(i);
        }

        System.out.println(objects);

    }
}
