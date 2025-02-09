package Baekjoon.Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {
                {2,5,3},
                {4,4,1},
                {1,7,3}
        };

        solution(array,commands);
    }

    private static void solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<commands.length; i++){
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            List<Integer> list = new ArrayList<>();

            for(int j = a-1; j<b; j++){
                list.add(array[j]);
            }

            Collections.sort(list);

            result.add(list.get(c-1));
        }

        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
