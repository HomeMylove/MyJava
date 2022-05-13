package myBreak;

/**
 * 输出97时停止，统计次数
 */
public class demo01 {
    public static void main(String[] args) {
        int number;
        int i;
        for( i=0;i<100;i++){
            number = (int) (Math.random() * 100 + 1);
            System.out.println(i);
            if(number == 97){
                break;
            }
        }
    }
}
