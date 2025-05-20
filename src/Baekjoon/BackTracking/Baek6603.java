package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek6603 {

    static int[] map, answer;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        while(true){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            if(N == 0){
                return;
            }

            map = new int[N];
            answer = new int[6];
            visited = new boolean[N];

            for(int i=0; i<N; i++){
                map[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            backTracking(0,0);
        }
    }

    private static void backTracking(int start, int depth){
        if(depth == 6){
            for(int num : answer){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = map[i];
                backTracking(i+1,depth+1);
                visited[i] = false;
            }
        }
    }
}
