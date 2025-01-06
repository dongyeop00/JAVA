package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15650_2 {

    static int[] map;
    static boolean[] visited;
    static int N, M;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[M];
        visited = new boolean[N];

        backTracking(0,0);
        System.out.println(stringBuilder);
    }

    public static void backTracking(int num, int depth){
        if(depth == M){
            for(int n : map){
                stringBuilder.append(n).append(' ');
            }
            stringBuilder.append('\n');
            return;
        }

        for(int i=num; i<N; i++){
            if(!visited[i]){
                map[depth] = i+1;
                visited[i] = true;
                backTracking(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}
