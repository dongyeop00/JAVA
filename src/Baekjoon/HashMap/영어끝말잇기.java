package Baekjoon.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] result = solution(n, words);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] solution(int n, String[] words){
        HashSet<String> set = new HashSet<>();
        char last = words[0].charAt(words[0].length()-1);

        for(int i=0; i<words.length; i++){
            String word = words[i];

            //중복 단어 검사
            if(set.contains(word)){
                return new int[]{(i%n)+1, (i/n)+1};
            }

            //끝말잇기 규칙 위반
            if(i>0 && last != word.charAt(0)){
                return new int[]{(i%n)+1, (i/n)+1};
            }

            set.add(word);
            last = word.charAt(word.length()-1);
        }

        return new int[]{0,0};
    }
}
