package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반_D4 {

    static int N, B, min;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            N = Integer.parseInt(stringTokenizer.nextToken());
            B = Integer.parseInt(stringTokenizer.nextToken());

            height = new int[N];
            min = Integer.MAX_VALUE;

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<N; i++){
                height[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            DFS(0, 0);

            System.out.println("#" + test_case + " " + min);

        }
    }

    private static void DFS(int index, int sum){
        if(sum >= B){
            min = Math.min(min, sum-B);
            return;
        }

        if(index >= N){
            return;
        }

        DFS(index+1, sum+height[index]);
        DFS(index+1, sum);
    }
}
