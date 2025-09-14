package Baekjoon.Study;

import java.util.Arrays;

public class 최장증가부분수열_DP {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 20, 50};
        int N = arr.length;
        int[] dp = new int[N];
        int maxLen = 0;

        for(int i=0; i<N; i++){
            dp[i] = 1; // 자기 자신만 포함하는 경우를 대비해 1로 초기화
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(maxLen);
    }
}
