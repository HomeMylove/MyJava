package myFor;

public class demo02 {
    public static void main(String[] args) {
        int count = 0;
        int num = 0;
        for(int i = 1; i < 100;i++){
            if(i % 9 == 0){
                System.out.println(i);
                count += i;
                num++;
            }
        }

        System.out.println("个数"+num);
        System.out.println("求和"+count);
    }
}
