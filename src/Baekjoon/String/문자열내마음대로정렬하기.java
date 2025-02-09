package Baekjoon.String;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        solution(strings, n);
    }

    public static void solution(String[] strings, int n){
        String[] answer = new String[strings.length];

        for(int i=0; i<strings.length; i++){
            char temp = strings[i].charAt(n);
            strings[i] = temp + strings[i];
        }

        Arrays.sort(strings);

        for(int i=0; i<strings.length; i++){
            strings[i] = strings[i].substring(1,strings[i].length());
            answer[i] = strings[i];
        }

        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
