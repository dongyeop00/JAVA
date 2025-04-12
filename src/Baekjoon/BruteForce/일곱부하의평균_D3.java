package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일곱부하의평균_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 0; test_case<T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int sum = 0;
            int max = 0;

            for(int i=0; i<6; i++){
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                sum += temp;
                max = Math.max(max, temp);
            }

            for(int i=max+1; i<10000; i++){
                if((sum + i) % 7 == 0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
