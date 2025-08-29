package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 외로운문자_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            String str = bufferedReader.readLine();
            int[] alph = new int[26];
            boolean flag = true;

            for(int i=0; i<str.length(); i++){
                alph[str.charAt(i) - 'a']++;
            }

            for(int i=0; i<26; i++){
                if(alph[i] % 2 != 0){
                    flag = false;
                }
            }

            System.out.print("#" + test_case + " ");
            if(flag){
                System.out.print("Good");
            }else{
                System.out.print("");
                for(int i=0; i<26; i++){
                    if(alph[i] % 2 !=0){
                        System.out.print((char)(i + 'a'));
                    }
                }
            }
            System.out.println();
        }
    }
}
