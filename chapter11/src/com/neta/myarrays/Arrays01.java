package com.neta.myarrays;

import java.util.Arrays;
import java.util.Comparator;

public class Arrays01 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,-2,-3};
        Arrays.sort(arr);
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
