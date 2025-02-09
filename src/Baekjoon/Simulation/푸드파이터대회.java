package Baekjoon.Simulation;

import java.util.ArrayList;
import java.util.List;

public class 푸드파이터대회 {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        solution(food);
    }

    private static void solution(int[] food){
        StringBuilder answer = new StringBuilder();
        String temp = "";

        for(int i=1; i<food.length; i++){
            int count = food[i] / 2;
            for(int j=0; j<count; j++){
                answer.append(String.valueOf(i));
            }
        }

        for(int i=answer.length()-1; i>=0; i--){
            temp += answer.charAt(i);
        }

        answer.append("0").append(temp);

        System.out.println(answer);
    }
}
