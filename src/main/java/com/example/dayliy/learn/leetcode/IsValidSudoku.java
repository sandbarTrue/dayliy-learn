package com.example.dayliy.learn.leetcode;

/**
 * @author zhoujun
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        char c='9';
        int cc=(int)c - (int)('0');
        System.out.println(cc);
    }
}

class IsValidSudokuSolution {
    public boolean isValidSudoku(char[][] board) {
        //用三个二维数组解题 分别表示某行、某列、某子九宫格是否出现 某个数字
        //难点在于如何确认某个下标所属的九宫格
        //如果知道了某个元素的下标是x j那么所属的子九宫格是i/3*3+j/3 观察规律所得，如果加一子九宫格
        //就是从1开始计数的，不然就是0
        int[][] row=new int[10][10];
        int[][] column=new int[10][10];
        int[][] child=new int[10][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int num=(int)board[i][j];
                if(0<=num && num<=9){
                    row[i][num]=row[i][num]+1;
                    column[j][num]=column[j][num]+1;
                    child[i/3*3+j/3][num]=child[i/3*3+j/3][num]+1;
                    if(row[i][num]>1 || column[j][num]>1 || child[i/3*3+j/3][num]>1){
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
