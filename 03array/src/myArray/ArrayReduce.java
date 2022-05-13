package myArray;

import java.util.Scanner;

public class ArrayReduce {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        char answer;
        do {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i];
            }
            System.out.println("已删除" + arr[arr.length - 1]);
            arr = newArr;
            System.out.println("新的数组");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            if (arr.length > 1) {
                System.out.println("是否继续删除? y/n");
                Scanner scanner = new Scanner(System.in);
                answer = scanner.next().charAt(0);
            } else {
                System.out.println("不能继续删除");
                break;
            }
        } while (answer == 'y');
    }
}
