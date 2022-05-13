package com.neta.mycollection.Homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HomeWork02 {
    public static void main(String[] args) {
        Employee jack = new Employee("Jack", 650);
        Employee tom = new Employee("tom", 1200);
        Employee smith = new Employee("smith", 2900);

        HashMap m = new HashMap();



        m.put(jack.getName(),jack.getSal());
        m.put(tom.getName(),tom.getSal());
        m.put(smith.getName(),smith.getSal());

        m.put(jack.getName(),2600.0);

        Set set = m.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Map.Entry entry = (Map.Entry) next;
//            System.out.println(entry.getValue().getClass());
            m.put(entry.getKey(),(Double)(entry.getValue())+100);
        }

        for (Object o : m.keySet()) {
            System.out.println(o);
        }

        for (Object value : m.values()) {
            System.out.println(value);
        }
    }
}

class Employee{
    private String name;
    private double sal;

    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}
