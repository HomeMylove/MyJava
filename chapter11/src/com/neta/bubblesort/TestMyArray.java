package com.neta.bubblesort;

import java.util.Arrays;
import java.util.Comparator;

public class TestMyArray {
    public static void main(String[] args) {
        int[] arr = {2,7,4,2,8,0,-4};
        Integer[] arr1 = {1,2,3,4};
        Integer[] arr2 = new Integer[]{1,2,3,4};

        Arrays.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println(Arrays.equals(arr1,arr2));


        System.out.println("排序前");
        System.out.println(MyArray.toString(arr));

        MyArray.sort(arr);
        System.out.println("排序后");
        System.out.println(MyArray.toString(arr));

        MyArray.sort(arr, new BubbleSort() {
            @Override
            public int compare(int a, int b) {
                int i = b - a;
                return i;
            }
        });

        System.out.println("传入匿名类");
        System.out.println(MyArray.toString(arr));

//        拷贝
        Arrays.copyOf(arr,arr.length);
    }
}
