package Baekjoon.Basic.Step4_1DArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(arr[0] + " " + arr[N-1]);
    }
}
