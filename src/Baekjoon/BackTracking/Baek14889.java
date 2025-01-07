package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14889 {

    static int N;
    static boolean[] visited;
    static int[][] synergy;
    static int minScore = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        visited = new boolean[N];
        synergy = new int[N][N];

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<N; j++){
                synergy[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        backTracking(0,0);
        System.out.println(minScore);
    }

    private static void backTracking(int start, int depth){
        if(depth == N/2){
            cal();
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]) {
                visited[i] = true;
                backTracking(i+1,depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void cal(){
        int start = 0;
        int link = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i] && visited[j]){
                    start += synergy[i][j];
                }else if(!visited[i] && !visited[j]){
                    link += synergy[i][j];
                }
            }
        }

        int min = Math.abs(start - link);
        minScore = Math.min(min, minScore);
    }
}
