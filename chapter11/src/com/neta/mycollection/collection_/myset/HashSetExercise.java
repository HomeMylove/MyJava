package com.neta.mycollection.collection_.myset;



import java.util.*;


public class HashSetExercise {
    public static void main(String[] args) {

        HashMap map = new HashMap();

       map.put("Yae","Miko");
       map.put("Ei","Shougun");
       map.put("Klee","Running sun");
       map.put("Jean","Captain");

        Set set = map.entrySet();

        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }

    }
}
