package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_D3 {

    static int N, K, count;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            number= new int[N];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<N; i++){
                number[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            count = 0;
            DFS(0,0);
            System.out.println("#" + test_case + " " + count);
        }
    }

    private static void DFS(int index, int sum){
        if(index == N){
            count++;
            return;
        }

        if(sum > K || index == N){
            return;
        }

        DFS(index+1, sum+number[index]);
        DFS(index+1, sum);
    }
}
