package homework;

public class demo01 {
    public static void main(String[] args) {
        double money = 100000;
        int count = 0; // 统计次数
        while (true) {
            if (money > 50000) {
                money -= money * 0.05;
            } else if (money > 1000 && money < 50000) {
                money -= 1000;
            } else {
                break;
            }
            System.out.println("这是第"+count+"次,还有"+money+"元");
            count++;
        }

        System.out.println("次数为" + count);

    }
}
