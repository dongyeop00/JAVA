package Baekjoon.Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        solution(numbers);
    }

    private static void solution(int[] numbers){
        List<Integer> temp = new ArrayList<>();

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                int sum = numbers[i] + numbers[j];
                if(!temp.contains(sum)){
                    temp.add(sum);
                }
            }
        }

        Collections.sort(temp);

        System.out.println(temp);
    }
}
