package myArray;

/**
 * 数组反转
 */
public class demo05 {
    public static void main(String[] args) {
        int[] arr = {1,23,4,5,6};
        for(int i = 0,j = arr.length-1; i < j;i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j]  = temp;
        }
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
