package Baekjoon.Simulation;

import java.util.Scanner;

public class 파리퇴치_D2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case<=T; test_case++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int max = 0;

            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<N-M+1; i++){
                for(int j=0; j<N-M+1; j++){
                    int sum = 0;
                    for(int a=i; a<i+M; a++){
                        for(int b=j; b<j+M; b++){
                            sum += map[a][b];
                        }
                    }

                    max = Math.max(max,sum);
                }
            }
            System.out.println(max);
        }
    }
}
