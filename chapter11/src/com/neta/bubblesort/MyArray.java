package com.neta.bubblesort;


public class MyArray {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }


    public static void sort(int[] a, BubbleSort b) {
        if (b == null) {
            return;
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (b.compare(a[j], a[j + 1]) > 0) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }


    public static String toString(int[] a) {
        if (a == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i != a.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return new String(sb);
    }
}
