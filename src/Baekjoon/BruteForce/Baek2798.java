package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2798 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] num = new int[n];

        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int max = 0;

        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    int sum = num[i] + num[j] + num[k];

                    if(sum <= m){
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
