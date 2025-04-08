package Baekjoon.Prefix;

import java.util.Scanner;

public class Sum_D3 {

    public static final int MAX = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for(int test_case = 1; test_case<=10; test_case++){
            int[][] map = new int[MAX][MAX];
            int T = sc.nextInt();
            for(int i=0; i<MAX; i++){
                for(int j=0; j<MAX; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            int row = rowSum(map);
            int col = colSum(map);
            int rightDiagonal = rightSum(map);
            int leftDiagonal = leftSum(map);

            int result = Math.max(row, Math.max(col, Math.max(rightDiagonal, leftDiagonal)));
            System.out.println("#" + T + " " + result);
        }
    }

    private static int rowSum(int[][] map){
        int max = Integer.MIN_VALUE;

        for(int i=0; i<MAX; i++){
            int sum = 0;
            for(int j=0; j<MAX; j++){
                sum += map[i][j];
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    private static int colSum(int[][] map){
        int max = Integer.MIN_VALUE;

        for(int i=0; i<MAX; i++){
            int sum = 0;
            for(int j=0; j<MAX; j++){
                sum += map[j][i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }

    private static int rightSum(int[][] map) {
        int sum = 0;
        for (int i = 0; i < MAX; i++) {
            sum += map[i][i];
        }
        return sum;
    }

    private static int leftSum(int[][] map) {
        int sum = 0;
        for (int i = 0; i < MAX; i++) {
            sum += map[i][MAX - 1 - i];
        }
        return sum;
    }
}
