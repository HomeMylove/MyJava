package homework;

public class demo02 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++){
            if(i % 5 != 0){
                count ++;
                if(count % 5 == 0){
                    System.out.println(i);
                }else{
                    System.out.print(i+" ");
                }
            }
        }
    }
}
