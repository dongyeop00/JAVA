package Baekjoon.BruteForce;

import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;

        int[] answer = solution(brown, yellow);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int brown, int yellow){
        int[] answer = new int[2];
        int total = brown + yellow;

        for(int i=3; i<total; i++){
            int col = i;
            int row = total/i;

            if((col-2)*(row-2) == yellow){
                answer[0] = col;
                answer[1] = row;
            }
        }

        return answer;
    }
}
