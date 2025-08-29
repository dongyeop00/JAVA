package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최소덧셈_D4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            int min = Integer.MAX_VALUE;
            int div = 10;

            while( div < N){
                int A = N / div;
                int B = N % div;
                int result = A+B;
                min = Math.min(min, result);
                div *= 10;
            }
            System.out.println("#" + test_case + " " + min);
        }
    }
}
