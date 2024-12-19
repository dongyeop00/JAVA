package Baekjoon.DP;

import java.util.Scanner;

public class Baek2748 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        System.out.println(fi(N));
    }

    private static long fi(int N){
        if(N == 0){
            return 0;
        }else if(N==1){
            return 1;
        }

        long[] dp = new long[N+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<N+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }
}
