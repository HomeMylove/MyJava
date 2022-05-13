package relational;

public class demo01 {
    public static void main(String[] args) {
        int a = 10;
        byte b = 10;
        System.out.println(a==b);

        int aa = 10;
        int bb = 20;
        byte e = a > b ? (byte)a : (byte)b;
        float c = aa > bb ? 10.1f : 20.1f;   // 错的
        double d = aa > bb ? 1.1 : 2.2;      // 对的
    }
}
