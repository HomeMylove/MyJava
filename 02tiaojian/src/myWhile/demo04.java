package myWhile;

public class demo04 {
    public static void main(String[] args) {
        int line = 10;
        for (int i = 1; i <= line; i++) {
            for (int m = 1; m <= line - i; m++) {
                System.out.print(' ');
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (i == 1 || i == line) {
                    System.out.print('*');
                } else {
                    if (j == 1 || j == 2 * i - 1) {
                        System.out.print('*');
                    } else {
                        System.out.print(' ');
                    }
                }
            }
            System.out.println();
        }
    }
}
