package homework;

public class Work05 {
    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.game(2);
        tom.game(2);
        tom.game(2);
        tom.game(2);
        tom.game(2);
        tom.show();
    }
}


class Tom{
    int[] record = new int[3];

    public void game(int numb){
        int comp = (int)(Math.random()*3);
        System.out.print("电脑出"+comp);
        System.out.print("\ttom出"+numb);
        int index;
        String result;
        switch (numb - comp){
            case 0:
                index= 2;
                result = "平局";
                break;
            case -1:
            case 2:
                index = 0;
                result = "Tom胜";
                break;
            default:
                index = 1;
                result = "电脑胜";
                break;
        }
        this.record[index]++;
        System.out.println("\t"+result);

    }

    public void show(){
        System.out.println("Tom胜利"+this.record[0]+"次");
        System.out.println("Tom失败"+this.record[1]+"次");
        System.out.println("Tom平局"+this.record[2]+"次");
    }

}
