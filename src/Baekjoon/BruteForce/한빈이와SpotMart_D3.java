package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한빈이와SpotMart_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int[] snack = new int[N];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<N; i++){
                snack[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int max = -1;

            for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    int sum = snack[i] + snack[j];
                    if(sum <= M){
                        max = Math.max(max, sum);
                    }
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}
