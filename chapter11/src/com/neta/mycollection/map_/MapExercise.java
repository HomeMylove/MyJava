package com.neta.mycollection.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        Employee yae = new Employee("Yae", 1000.0, "0001");
        Employee ei = new Employee("Ei", 20000.00, "0002");
        Employee sara = new Employee("Sara", 50000.0, "0003");

        map.put(sara.getId(),sara);
        map.put(ei.getId(),ei);
        map.put(yae.getId(),yae);

        // keySet
        Set set = map.keySet();

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if(map.get(next) instanceof Employee){
                Employee employee = (Employee) map.get(next);
//                System.out.println(employee);
                if(employee.getSal()>18000){
                    System.out.println(employee);
                }
            }
        }

        System.out.println("===============");

        Set set1 = map.entrySet();

        for (Object o : set1) {
            Map.Entry entry = (Map.Entry) o;

            if(entry.getValue() instanceof Employee){
                Employee employee = (Employee) entry.getValue();
                if(employee.getSal() > 18000){
                    System.out.println(employee);
                }
            }
        }


    }
}

class Employee{
    private String name;
    private double sal;
    private String id;

    public Employee(String name, double sal, String id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
