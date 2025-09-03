package Baekjoon.DP;

import java.util.Scanner;

public class 계단오르기_바텀업 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] stair = new int[N+1];
        int[][] dp = new int[N+1][3];

        for(int i=1; i<N+1; i++){
            stair[i] = sc.nextInt();
        }

        for(int i=1; i<N+1; i++){
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = dp[i-1][0] + stair[i];
            dp[i][2] = dp[i-1][1] + stair[i];
        }

        int result = Math.max(dp[N][1], dp[N][2]);
        System.out.println(result);
    }
}
