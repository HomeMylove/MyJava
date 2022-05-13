package myBreak;

/**
 * 记录求和第一次大于20的值
 */
public class demo02 {
    public static void main(String[] args) {
        int count = 0;
        for(int i =1; i <= 100; i++){
           count += i;
           if(count > 20){
               System.out.println(i);
               System.out.println(count);
               break;
           }
        }
    }
}
