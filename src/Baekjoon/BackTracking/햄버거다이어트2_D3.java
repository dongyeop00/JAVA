package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거다이어트2_D3 {

    static Food[] foods;
    static int N, L;
    static int totalScore, totalKcal, maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            N = Integer.parseInt(stringTokenizer.nextToken());
            L = Integer.parseInt(stringTokenizer.nextToken());

            foods = new Food[N];
            totalKcal = 0;
            totalScore = 0;
            maxScore = Integer.MIN_VALUE;

            for(int i=0; i<N; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int score = Integer.parseInt(stringTokenizer.nextToken());
                int kcal = Integer.parseInt(stringTokenizer.nextToken());

                foods[i] = new Food(score, kcal);
            }

            backTracking(0, 0,0);
            System.out.println("#" + test_case + " " + maxScore);
        }
    }

    private static void backTracking(int index, int totalScore, int totalKcal){

        if(index == N){
            if(totalKcal <= L){
                maxScore = Math.max(maxScore, totalScore);
            }
            return;
        }

        backTracking(index+1, totalScore+foods[index].score, totalKcal+foods[index].kcal);
        backTracking(index+1, totalScore, totalKcal);
    }

    private static class Food{
        int score;
        int kcal;

        Food(int score, int kcal){
            this.score = score;
            this.kcal = kcal;
        }
    }
}
