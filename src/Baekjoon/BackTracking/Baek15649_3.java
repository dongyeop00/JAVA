package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15649_3 {

    static boolean[] visited;
    static int[] map;

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[M];
        visited = new boolean[N];

        backTracking(0);
    }

    private static void backTracking(int depth){
        if(depth == M){
            for(int num : map){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]) {
                visited[i] = true;
                map[depth] = i+1;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
