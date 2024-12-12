package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1316 {
    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bf.readLine());
        int count = 0;

        for(int i=0; i<testCase; i++){
            String str = bf.readLine();
            if(solution(str)){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean solution(String str){
        boolean[] check = new boolean[26];
        int prev = 0;

        for(int i = 0; i<str.length(); i++){
            int c = str.charAt(i);

            if(prev != c){ //전 문자와 같지 않다면

                // 전 문자와 같지 않은데 처음 나오는거라면?
                if(!check[c - 'a']){
                    check[c-'a'] = true;
                    prev = c;
                }else{
                    return false;
                }
            }

            continue;
        }

        return true;
    }
}
