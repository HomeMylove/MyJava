package com.neta.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Generic04 {
    public static void main(String[] args) {
        Employee yae = new Employee("Yae", 1000.0, new MyDate(200, 10, 12));
        Employee ei = new Employee("Ei", 2000, new MyDate(1999, 8, 12));
        Employee ayaka = new Employee("Ayaka", 900.0, new MyDate(2005, 9, 18));
        Employee yae1 = new Employee("Yae", 10, new MyDate(2000, 3, 12));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(yae);
        employees.add(ei);
        employees.add(ayaka);
        employees.add(yae1);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 != null && o2 != null)) {
                    System.out.println("类型错误");
                    return 0;
                }
                int result;
                return (result = o1.getName().compareTo(o2.getName())) == 0 ? o1.getBirthday().compareTo(o2.getBirthday()): result;

            }
        });

        System.out.println(employees);
    }
}


class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}

class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "年" +
                month + "月" +
                day + "日";
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(MyDate date) {
        int result;
        if ((result = year - date.getYear()) != 0) {
            return result;
        } else if ((result = month - date.getMonth()) != 0) {
            return result;
        } else {
            return day - date.getDay();
        }
    }
}
