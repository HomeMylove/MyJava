package myArray;

import java.util.Scanner;

public class demo02 {
    public static void main(String[] args) {
        double[] arr = new double[5];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i <arr.length; i++){
            arr[i] = scanner.nextDouble();
        }


        for(int j = 0; j < arr.length; j++){
            System.out.println("第"+j+"个是"+arr[j]);
        }
    }
}
