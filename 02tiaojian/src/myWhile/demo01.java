package myWhile;

public class demo01 {
    public static void main(String[] args) {
        int num = 1;
        int count = 0;
        do{
            System.out.println("num=" + num++);
            count += num;
        }while(num<=100);

        System.out.println("count=" + count);
    }
}
