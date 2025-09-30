package Baekjoon.BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class 행운의문자열 {

    static int[] alph;
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        N = str.length();
        alph = new int[26];

        for(int i=0; i<N; i++){
            alph[str.charAt(i) - 'a']++;
        }

        DFS(-1, 0);
        System.out.println(count);
    }

    public static void DFS(int prev, int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i=0; i<26; i++){
            if(alph[i] == 0) continue;
            if(i == prev) continue;
            alph[i]--;
            DFS(i, depth+1);
            alph[i]++;
        }
    }
}
