package Baekjoon.Simulation;

public class 가장가까운같은글자Array {
    public static void main(String[] args) {
        String str = "banana";
        solution(str);
    }

    private static void solution(String s){
        int[] answer = new int[s.length()];
        int[] alph = new int[26];

        for(int i=0; i<26; i++){
            alph[i] = -1;
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(alph[c-'a'] != -1){
                answer[i] = i - alph[c-'a'];
            }else{
                answer[i] = -1;
            }
            alph[c-'a'] = i;
        }

        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
