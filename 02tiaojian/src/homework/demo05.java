package homework;

public class demo05 {
    public static void main(String[] args) {
        int count = 0;
        int sum;
        for(int i = 1; i <= 100; i++){
            sum = 0;
            for(int j = 1; j <= i; j++){
                sum += j;
            }
            count += sum;
        }
        System.out.println("count="+count);
    }
}
