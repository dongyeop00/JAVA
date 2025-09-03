package Baekjoon.DP;

import java.util.Scanner;

public class 계단오르기_탑다운 {

    static int N;
    static int[] stair;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        stair = new int[N+1];
        dp = new int[N+1][3];

        for(int i=1; i<N+1; i++){
            stair[i] = sc.nextInt();
        }

        for(int i=0; i<N+1; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = -1;
            }
        }

        int result = Math.max(dfs(N, 1), dfs(N, 2));
        System.out.println(result);
    }

    public static int dfs(int N, int state){
        if(N <= 0) return 0;

        if(dp[N][state] != -1) return dp[N][state];

        if(state == 1){
            // 직접 계단을 밟은 경우 -> 이전 계단은 state=0
            dp[N][state] = dfs(N-1, 0) + stair[N];
        } else if(state == 2){
            // 직접 계단을 1번 밟은 경우 -> 이전 계단은 state=1
            dp[N][state] = dfs(N-1, 1) + stair[N];
        } else{ // state == 0
            // 이번 계단을 안 밟음 -> 이전 계단은 1,2 중 큰 값
            dp[N][state] = Math.max(dfs(N-1, 1), dfs(N-1, 2));
        }

        return dp[N][state];
    }
}
