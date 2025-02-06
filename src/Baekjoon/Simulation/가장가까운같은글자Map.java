package Baekjoon.Simulation;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운같은글자Map {
    public static void main(String[] args) {
        String str = "banana";
        solution(str);
    }

    private static void solution(String s){
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                answer[i] = i - map.get(c);
            }else{
                answer[i] = -1;
            }
            map.put(c,i);
        }

        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}