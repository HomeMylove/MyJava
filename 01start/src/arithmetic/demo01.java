package arithmetic;

public class demo01 {
    public static void main(String[] args) {
        System.out.println(10 / 4);  // 2
        System.out.println(10.0 / 4);  //2.5
        double d = 10 / 4;
        System.out.println(d);   //2.0
        double dd = 10.0 / 4;
        System.out.println(dd);   //2.5

        int i = 10;
        int k;
        k = ++i;
        System.out.println("k=" + k);
        k = i++;
        System.out.println("k=" + k);
        k = i;
        System.out.println(k);
    }
}
