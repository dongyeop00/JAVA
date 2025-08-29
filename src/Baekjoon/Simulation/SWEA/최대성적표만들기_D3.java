package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최대성적표만들기_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());

            int[] score = new int[N];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for(int i=0; i<N; i++){
                score[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Arrays.sort(score);

            int sum = 0;
            for(int i=N-1; i>=N-K; i--){
                sum += score[i];
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
