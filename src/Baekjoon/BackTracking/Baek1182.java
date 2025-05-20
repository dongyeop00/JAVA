package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1182 {

    static int[] map;
    static int N, S, count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N];
        count = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        backTracking(0,0);
        if(S == 0){
            System.out.println(count -1);
        }else{
            System.out.println(count);
        }
    }

    private static void backTracking(int depth, int sum){
        if(depth == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        backTracking(depth+1, sum+map[depth]);
        backTracking(depth+1, sum);
    }
}
