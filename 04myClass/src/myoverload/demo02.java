package myoverload;

public class demo02 {
    public static void main(String[] args) {
        Methods methods = new Methods();
        System.out.println(methods.m(5));
        System.out.println(methods.m(5,6));
        methods.m("Hello world");
    }
}


class Methods{
    public int m(int n){
        return n * n;
    }

    public int m(int n1,int n2){
        return n1 * n2;
    }

    public void m(String str){
        System.out.println(str);
    }
}
