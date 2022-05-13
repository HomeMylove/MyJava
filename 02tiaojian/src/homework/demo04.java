package homework;

public class demo04 {

    public static void main(String[] args) {
        double count = 0;

        for (int i = 1; i <= 100; i++) {

            if (i % 2 != 0) {
                count += 1.0 / i;
            } else {
                count -= 1.0 / i;
            }
        }

        System.out.println("count=" + count);
    }

}
