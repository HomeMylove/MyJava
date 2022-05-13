package com.neta.mycollection.collection_.myset;

public class MyData {
    private int year;
    private int month;
    private int day;

    public MyData(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyData myData = (MyData) o;

        if (year != myData.year) return false;
        if (month != myData.month) return false;
        return day == myData.day;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }
}
