package jinjie;

public class Puzzle {
    public static void main(String[] args) {
        // 创建迷宫
        int[][] map = new int[8][7];
        // 填充上下两行
        for(int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        map[6][4] = 1;
        // 填充左右两列
        for(int i = 0; i < 8; i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        showMap(map);
        findWay(map,1,1);
        showMap(map);
    }
    /*
    1.findWay方法就是专门来找出迷宫的路径
    2.如果找到，就返回true,否则返回false
    3.map就是二维数组，即表示迷宫
    4.i,j就是老鼠的位置，初始化的位置为(1,1)
    5.因为我们是递归的找路，所以我先规定map数组的各个值的含义
        0表示可以走
        1表示障碍物
        2表示可以走
        3表示走过，但是走不通是死路
    6.当map[6][5]=2就说明找到通路，否则就继续找，
    7.找路策略: 下 -> 右 -> 上 -> 左
     */
    public static boolean findWay(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){
                // 假定可以走
                map[i][j] = 2;
                if(findWay(map,i+1,j)){// 往下走
                    return true;
                }else if(findWay(map,i,j+1)){
                    return true;
                }else if(findWay(map,i-1,j)){
                    return true;
                }else if(findWay(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }



    public static void showMap(int[][] arr){
        System.out.println("===地图情况===");
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
