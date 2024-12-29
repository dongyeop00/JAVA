package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1010 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int testCase = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<testCase; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int r = Integer.parseInt(stringTokenizer.nextToken()); //서쪽
            int n = Integer.parseInt(stringTokenizer.nextToken()); //동쪽

            dp = new int[n+1][r+1];

            // nCr을 구하는 문제
            System.out.println(Combination(n, r));
        }
    }

    private static int Combination(int n, int r){

        if(n == r || r == 0){
            return 1;
        }

        if(dp[n][r] != 0){
            return dp[n][r];
        }

        // 점화식: mCn = [(n-1)C(r-1)] + [(n-1)C(r)]
        dp[n][r] = Combination(n-1,r-1) + Combination(n-1, r);
        return dp[n][r];
    }

}
