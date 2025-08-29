package Baekjoon.Simulation.SWEA;

import java.util.*;
import java.io.*;

public class 파리퇴치3_D2 {
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int[][] map = new int[N][N];
            int max = Integer.MIN_VALUE;

            for(int i=0; i<N; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    int plusSum = map[i][j];
                    int diaSum = map[i][j];

                    for(int k=1; k<M; k++) {
                        // + 모양
                        //상
                        if(i-k >= 0) plusSum += map[i-k][j];
                        //우
                        if(j+k < N) plusSum += map[i][j+k];
                        //하
                        if(i+k < N) plusSum += map[i+k][j];
                        //좌
                        if(j-k >= 0) plusSum += map[i][j-k];

                        // X 모양
                        // 좌상
                        if(i-k >= 0 && j-k >= 0) diaSum += map[i-k][j-k];
                        // 우상
                        if(i-k >= 0 && j+k < N) diaSum += map[i-k][j+k];
                        // 좌하
                        if(i+k < N && j-k >= 0) diaSum += map[i+k][j-k];
                        // 우하
                        if(i+k < N && j+k < N) diaSum += map[i+k][j+k];
                    }

                    max = Math.max(max, Math.max(plusSum, diaSum));
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}
