package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15652 {

    static int[] map;
    static int N,M;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[M];

        backTracking(1,0);
        System.out.println(stringBuilder);
    }

    private static void backTracking(int n, int depth){

        if(depth == M){
            for(int num : map){
                stringBuilder.append(num).append(' ');
            }
            stringBuilder.append('\n');
            return;
        }

        for(int i=n; i<=N; i++){
            map[depth] = i;
            backTracking(i,depth+1);
        }
    }
}
