package Baekjoon.Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반 {

    static int N, B, min = Integer.MAX_VALUE;
    static int[] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            height = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                height[i] = Integer.parseInt(st.nextToken());
            }

            subset(0, 0);
            System.out.println("#" + test_case + " " + min);
        }
    }

    public static void subset(int depth, int sum){
        if(depth == N){
            if(sum >= B){
                min = Math.min(min, sum - B);
            }
            return;
        }

        subset(depth+1, sum + height[depth]);
        subset(depth+1, sum);
    }
}
