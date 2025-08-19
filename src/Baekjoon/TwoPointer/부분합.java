package Baekjoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {

    static int N, S;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        twoPointer();
        System.out.println(min);
    }

    private static void twoPointer(){
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while(true){
            if(sum >= S){
                sum -= arr[start++];
                min = Math.min(count, min);
                count--;
            }else if(end == N){
                if(min == Integer.MAX_VALUE){
                    min = 0;
                }
                break;
            }else{
                sum += arr[end++];
                count++;
            }
        }
    }
}
