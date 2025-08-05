package Baekjoon.DP;

import java.util.*;
import java.io.*;

public class Baek16974 {

    static long[] total_layer;
    static long[] patty_layer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        total_layer = new long[N+1];
        patty_layer = new long[N+1];

        total_layer[0] = 1;
        patty_layer[0] = 1;

        for(int i=1; i<=N; i++) {
            total_layer[i] = (total_layer[i-1])*2 + 3;
            patty_layer[i] = (patty_layer[i-1])*2 + 1;
        }

        long result = solution(N,K);
        System.out.println(result);
    }

    public static long solution(int N, long K) {
        if(N == 0) {
            return K == 0 ? 0 : 1;
        }

        long mid = total_layer[N-1] + 1; // 중앙 인덱스

        if(K==1) { // 하나만 먹었을 때
            return 0;

        }else if(K == mid+1) { // 딱 절반 먹었을 때
            return patty_layer[N-1]+1;

        }else if(K <= mid) { // 절반 미만 먹었을 때
            return solution(N-1, K-1);

        }else if(K >= mid){ // 절반 초과 먹었을 때
            return patty_layer[N-1] + 1 + solution(N-1, K - mid - 1);

        }else { // 다 먹었을 때
            return patty_layer[N];

        }

    }
}

