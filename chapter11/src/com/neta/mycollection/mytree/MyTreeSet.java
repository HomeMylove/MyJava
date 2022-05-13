package com.neta.mycollection.mytree;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String[] args) {

       TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String) o2);
            }
        });

        treeMap.put("Cyro",12);
        treeMap.put("Andy",13);
        treeMap.put("Boby",14);

        for (Object o : treeMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }

    }
}
