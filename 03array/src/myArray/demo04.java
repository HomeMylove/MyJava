package myArray;

public class demo04 {
    public static void main(String[] args) {
        int[] arr = {4, -1, 9, 10, 23};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        System.out.println("max is " + max);
    }
}

