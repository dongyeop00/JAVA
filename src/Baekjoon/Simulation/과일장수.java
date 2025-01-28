package Baekjoon.Simulation;

import java.util.Arrays;

public class 과일장수 {
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        solution(k,m,score);
    }

    private static void solution(int k, int m, int[] score){
        Arrays.sort(score);

        int sum = 0;

        for(int i=score.length-m; i>=0; i -= m){
            sum += score[i]*m;
        }

        System.out.println(sum);
    }
}
