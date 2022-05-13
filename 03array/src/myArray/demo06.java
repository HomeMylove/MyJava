package myArray;

public class demo06 {
    public static void main(String[] args) {
        int[] arr = {10, 12, 45, 90};
        int num = 23;
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < num) {
                newArr[i] = arr[i];
                if (num < arr[i + 1]) {
                    newArr[i + 1] = num;
                }
            } else {
                newArr[i + 1] = arr[i];
            }
        }

        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
