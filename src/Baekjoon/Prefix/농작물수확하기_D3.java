package Baekjoon.Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 농작물수확하기_D3{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case=1; test_case<=T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());

            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                String str = bufferedReader.readLine();
                for(int j=0; j<N; j++){
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            int mid = N / 2;
            int sum = 0;

            for(int i=0; i<N; i++){
                int num = Math.abs(mid-i);
                for(int j=num; j<N-num; j++){
                    sum += map[i][j];
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
