package Baekjoon.Simulation;

import java.util.Scanner;

public class 최빈수구하기_D2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case<=T; test_case++){
            int N = sc.nextInt();
            int[] score = new int[101];
            int max = 0;
            int maxScore = 0;

            for(int i=0; i<1000; i++){
                int temp = sc.nextInt();
                score[temp]++;
            }

            for(int i=0; i<score.length; i++){
                if(max <= score[i]){ //최빈수가 여러개일 땐 가장 큰 점수로
                    max = score[i];
                    maxScore = i;
                }
            }

            System.out.println(maxScore);
        }
    }
}
