package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10819 {

    static int[] map, answer;
    static boolean[] visited;
    static int N, max;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        max = Integer.MIN_VALUE;
        map = new int[N];
        answer = new int[N];
        visited = new boolean[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        backTracking(0);
        System.out.println(max);
    }

    private static void backTracking(int depth){
        if(depth == N){
            int sum = 0;
            for(int i=0; i<N-1; i++){
                sum += Math.abs(answer[i] - answer[i+1]);
            }
            max = Math.max(sum, max);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = map[i];
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
