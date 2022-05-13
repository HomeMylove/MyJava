package start;

public class demo02 {
    public static void main(String[] args) {
        AA a = new AA();
        System.out.println(a.oddOrEven(19));
        System.out.println(a.oddOrEven(20));

        a.print(4,3,'*');
    }
}


class AA{
    public boolean oddOrEven(int n){
        return n % 2 == 0;
    }

    public void print(int line,int row,char mark){
        for(int i = 0; i < line; i++){
            for(int j = 0; j < row; j++){
                System.out.print(mark);
            }
            System.out.println();
        }
    }
}