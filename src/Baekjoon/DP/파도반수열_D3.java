package Baekjoon.DP;

import java.util.Scanner;

public class 파도반수열_D3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for(int test_case=1; test_case<=T; test_case++){
            int N = scanner.nextInt();

            long[] dp = new long[101];

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;

            for(int i=5; i<101; i++){
                dp[i] = dp[i-2] + dp[i-3];
            }

            System.out.println("#" + test_case + " " + dp[N]);
        }
    }
}
