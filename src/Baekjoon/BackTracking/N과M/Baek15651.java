package Baekjoon.BackTracking.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15651 {

    static int[] map;
    static int N,M;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[M];

        backTracking(0);
        System.out.println(stringBuilder);
    }

    private static void backTracking(int depth){

        if(depth == M){
            for(int num : map){
                stringBuilder.append(num).append(' ');
            }
            stringBuilder.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            map[depth] = i+1;
            backTracking(depth+1);
        }
    }
}
