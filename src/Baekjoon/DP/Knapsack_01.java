package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Knapsack 0-1 풀이
public class Knapsack_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 물건의 개수
            int K = Integer.parseInt(st.nextToken()); // 가방의 부피

            int[] weight = new int[N+1]; // 부피
            int[] value = new int[N+1]; // 가치

            for(int i=1; i<N+1; i++){
                st = new StringTokenizer(br.readLine());
                weight[i] = Integer.parseInt(st.nextToken());
                value[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println("부피 : " + Arrays.toString(weight));
            System.out.println("가치 : " + Arrays.toString(value));

            // 앞에서 i번째 물건까지 고려했을 때, 가방 용량이 j일 때의 최대 가치
            int[][] dp = new int[N+1][K+1];

            for(int i=1; i<N+1; i++){ // 물건 종류 : 1~N까지
                for(int j=1; j<K+1; j++){ // 가방의 부피 : 1~K까지
                    if(j < weight[i]){ // 물건 i의 무게가 현재 용량 j보다 크면 담을 수 없음
                        dp[i][j] = dp[i-1][j]; // 이전 상태 그대로
                    }else{ // 담을 수 있으면 두 가지 경우 중 최대 선택
                        // 물건 i를 담는다 : dp[i-1][j - weight[i]] + value[i]
                        // 물건 i를 담지 않는다. : dp[i-1][j]
                        dp[i][j] = Math.max(dp[i-1][j-weight[i]] + value[i], dp[i-1][j]);
                    }
                }
            }

            // dp 배열
            for(int i=0; i<N+1; i++){
                for(int j=0; j<K+1; j++){
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("#" + testCase + " " + dp[N][K]);
        }
    }
}
