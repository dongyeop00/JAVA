package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 0; test_case<T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] map = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            for(int i=0; i<2; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=1; j<N+1; j++){
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            dp[0][0] = dp[1][0] = 0;
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];

            for(int i=2; i<N+1; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
