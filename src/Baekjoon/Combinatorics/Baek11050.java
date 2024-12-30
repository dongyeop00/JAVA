package Baekjoon.Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11050 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        dp = new int[N+1][K+1];

        System.out.println(Combination(N,K));
    }

    private static int Combination(int N, int K){
        // nCk

        if(N == K || K == 0){
            return 1;
        }

        if(dp[N][K] != 0){
            return dp[N][K];
        }

        dp[N][K] = Combination(N-1, K-1) + Combination(N-1, K);
        return dp[N][K];
    }
}
