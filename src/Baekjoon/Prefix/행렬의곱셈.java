package Baekjoon.Prefix;

public class 행렬의곱셈 {
    public static void main(String[] args) {
        int[][] arr1 = {{1,4},{3,2},{4,1}}; // 3x2
        int[][] arr2 = {{3,3},{3,3}}; // 3x3

        int row_a1 = arr1.length;
        int col_a1 = arr1[0].length;
        int row_a2 = arr2.length;
        int col_a2 = arr2[0].length;

        // 3x3
        int[][] answer = new int[row_a1][col_a2];

        for(int i=0; i<row_a1; i++){
            for(int j=0; j<col_a2; j++){
                for(int k=0; k<col_a1; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[0].length; j++){
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }
}
