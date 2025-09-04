package Baekjoon.BackTracking.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15649 {

    static boolean[] visited;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[M];
        visited = new boolean[N];

        backTracking(N, M, 0);
    }

    private static void backTracking(int N, int M, int depth){

        if(depth == M){
            for(int num : map){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                map[depth] = i+1;
                backTracking(N, M, depth+1);
                visited[i] = false;
            }
        }
    }
}
