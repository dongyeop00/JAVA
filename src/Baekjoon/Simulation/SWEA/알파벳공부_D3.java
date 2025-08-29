package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳공부_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            String str = bufferedReader.readLine();
            char start = 'a';
            int count = 0;

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == start++){
                    count++;
                }else{
                    break;
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
