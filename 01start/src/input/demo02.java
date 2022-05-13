package input;

public class demo02 {
    public static void main(String[] args) {
//        2|3
//        2 的补码 00000000 00000000 00000000 00000010
//        3 的补码 00000000 00000000 00000000 00000011
//        或运算   00000000 00000000 00000000 00000011 就是原码
//        结果为3
        System.out.println(2|3);  //3
        System.out.println(2^3);  //1

        String str = "123";
        double d = Integer.parseInt(str);

        char c = 'a';
        String s= c + "";


        System.out.println(d);
        System.out.println(s instanceof String);





    }
}
