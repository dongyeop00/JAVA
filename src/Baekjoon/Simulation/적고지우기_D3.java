package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적고지우기_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case<=T; test_case++){
            String str = bufferedReader.readLine();
            int[] array = new int[10];

            for(int i=0; i<str.length(); i++){
                if(array[str.charAt(i)-'0'] > 0){
                    array[str.charAt(i)-'0']--;
                }else{
                    array[str.charAt(i)-'0']++;
                }
            }

            int count = 0;
            for(int i=0; i<10; i++){
                if(array[i] > 0){
                    count++;
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
