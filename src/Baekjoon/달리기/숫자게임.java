package Baekjoon.달리기;

import java.io.*;

public class 숫자게임 {
    static int[] dp;
    static int a;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp = new int[100000];
        for(int i = 10; i <= 99999; i++) {
            backTracking(i, i, 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++) {
            a = Integer.parseInt(br.readLine());
            sb.append("#").append(t).append(" ").append(dp[a]).append("\n");
        }

        System.out.println(sb);
    }

    /**
     *
     * @param current : 원본 숫자
     * @param val : 현재처리 중인 왼쪽 값
     * @param multi : 현재까지 선택한 오른쪽 조각들의 곱
     */
    public static void backTracking(int current, int val, int multi) {

        // dp[val * multi] + 1 해주는 이유는 분해했으니 분해수 + 1 해줘야됨
        dp[current] = Math.max(dp[current], dp[val * multi] + 1);

        if(val < 10) return;

        int radix = 10;

        // 99999 -> 9999 9 -> 9 9 9 9 9
        while(radix < val) {
            backTracking(current, val / radix, multi * (val % radix));
            radix *= 10;
        }
    }

}
