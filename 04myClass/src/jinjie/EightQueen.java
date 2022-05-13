package jinjie;

public class EightQueen {
    public static void main(String[] args) {
        int[] chess = new int[8];

        solve(chess,0,0);

        showChess(chess);

    }


    public static boolean solve(int[] chess, int x, int y) {
        chess[x] = y;
        showChess(chess);
        if (x == 7 && check(chess, x+1)) {
            return true;
        } else {
            if(check(chess,x+1)){
               return true;
            } else{
                chess[x] = 0;
                return false;
            }
        }
    }

    // row 检查几行
    public static boolean check(int[] chess, int row) {
        for (int i = 0; i < row - 1; i++) {
            for (int j = i + 1; j < row; j++) {
                if (chess[i] - chess[j] == i - j || chess[i] - chess[j] == j - i || chess[i] == chess[j]) {
//                    System.out.println("x=" + i + " y=" + j);
                    return false;
                }
            }
        }
        return true;
    }

    public static void showChess(int[] chess){
        for(int i = 0; i < chess.length; i++){
            System.out.print(chess[i]+" ");
        }
        System.out.println();
    }
}