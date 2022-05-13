package com.neta.mycollection.Homework;

import java.util.HashSet;

public class HomeWork03 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person("AA", 1001);
        Person p2 = new Person("BB", 1002);
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1); // 删除失败
        System.out.println(set);
        set.add(new Person("CC",1001));
        System.out.println(set);
        set.add(new Person("AA",1001));
        System.out.println(set);
    }
}

class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
