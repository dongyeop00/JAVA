package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 캠프준비 {

    static int N, L, R, X, result;
    static int[] problem;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        result = 0;

        problem = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            problem[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);
        System.out.println(result);
    }

    public static void backTracking(int depth){
        if(depth == N){
            if(check(visited) >= 2){
                int sum = 0;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int i=0; i<N; i++){
                    if(visited[i]){
                        sum += problem[i];
                        min = Math.min(min, problem[i]);
                        max = Math.max(max, problem[i]);
                    }
                }

                if(L <= sum && sum <= R){
                    if(Math.abs(min - max) >= X){
                        result++;
                    }
                }
            }
            return;
        }

        visited[depth] = true;
        backTracking(depth+1);

        visited[depth] = false;
        backTracking(depth+1);
    }

    public static int check(boolean[] visited){
        int count = 0;
        for(int i=0; i<N; i++) {
            if (visited[i]) {
                count++;
            }
        }
        return count;
    }
}
