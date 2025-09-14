package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최장증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            int maxLen = 0;

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<N; i++){
                dp[i] = 1;
                for(int j=0; j<i; j++){
                    if(arr[i] > arr[j]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                maxLen = Math.max(maxLen, dp[i]);
            }

            System.out.println("#" + testCase + " " + maxLen);
        }
    }
}
