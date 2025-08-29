package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한숫자_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] array = new int[N];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<N; i++){
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int count = 0;

            for(int i=1; i<N-1; i++){
                int max = Math.max(array[i-1], Math.max(array[i], array[i+1]));
                int min = Math.min(array[i-1], Math.min(array[i], array[i+1]));

                if(array[i] != max && array[i] != min){
                    count++;
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
