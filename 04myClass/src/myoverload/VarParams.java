package myoverload;

public class VarParams {
    public static void main(String[] args) {
        Method method = new Method();
        System.out.println(method.sum());
        System.out.println(method.sum(1,2,3));

        int[] arr = {1,2,3,4,4};
        System.out.println(method.sum(arr));
    }
}

class Method{
    public int sum(int...numbs){
        int count = 0;
        for(int i = 0; i< numbs.length; i++){
            count += numbs[i];
        }
        return count;
    }

    public void showScore(String name,double...score){
        int count = 0;
        for(int i = 0; i < score.length; i++){
            count += score[i];
        }
        System.out.println(name+"的总成绩是"+count);
    }
}
