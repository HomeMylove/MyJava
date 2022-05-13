package myArray;

public class demo07 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println("数组正序========");
        // avg
        int count = 0;
        int index = 0,max = arr[index];
        int flag = -1;

        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
            count += arr[i];
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }
            if(arr[i]==8){
                flag = i;
            }
        }

        // 倒叙
        System.out.println("倒序打印===========");
        for(int i = arr.length-1; i >=0; i--){
            System.out.print(arr[i]+" ");
        }

        System.out.println("平均值="+(int)(count/10));
        System.out.println("最大值="+max);
        System.out.println("下标="+index);

        if(flag == -1){
            System.out.println("没有8");
        }else{
            System.out.println("有8");
        }





    }
}
