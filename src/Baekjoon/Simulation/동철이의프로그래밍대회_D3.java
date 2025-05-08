package Baekjoon.Simulation;

import java.util.Scanner;

public class 동철이의프로그래밍대회_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int winner = 0;
            int max = 0;

            int[][] map = new int[N][M];
            int[] result = new int[N];

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<N; i++){
                int count = 0;
                for(int j=0; j<M; j++){
                    if(map[i][j] == 1){
                        count++;
                    }
                }

                result[i] = count;
                max = Math.max(count, max);
            }

            for(int i=0; i<N; i++){
                if(result[i] == max){
                    winner++;
                }
            }

            System.out.println("#" + test_case + " " + winner + " " + max);
        }
    }
}
