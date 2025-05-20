package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15652_2 {

    static int[] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[M];

        backTracking(0,0);
    }

    private static void backTracking(int start, int depth){
        if(depth == M){
            for(int num : map){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<N; i++){
            map[depth] = i+1;
            backTracking(i,depth+1);
        }
    }
}
