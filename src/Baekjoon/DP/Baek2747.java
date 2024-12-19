package Baekjoon.DP;

import java.util.Scanner;

public class Baek2747 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        if(N == 0){
            System.out.println(0);
            return;
        }else if(N==1){
            System.out.println(1);
            return;
        }

        int[] dp = new int[N+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<N+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}
