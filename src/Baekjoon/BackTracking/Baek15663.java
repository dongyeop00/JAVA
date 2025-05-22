package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek15663 {

    static int[] map, answer;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N];
        answer = new int[M];
        visited = new boolean[10000];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(map);

        backTracking(0);
    }

    private static void backTracking(int depth){
        if(depth == M){
            for(int num : answer){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        int before = -1;
        for(int i=0; i<N; i++){
            if(!visited[i] && before != map[i]){
                visited[i] = true;
                answer[depth] = map[i];
                before = map[i];
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
