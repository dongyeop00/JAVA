package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소득불균형_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] array = new int[N];
            int sum = 0, count = 0;

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<N; i++){
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                array[i] = temp;
                sum += temp;
            }

            sum /= N;

            for(int i=0; i<N; i++){
                if(sum >= array[i]){
                    count++;
                }
            }

            System.out.println("#"+test_case+" "+count);
        }
    }
}
