package Baekjoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[N];
        int count = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr);

        int x = Integer.parseInt(bufferedReader.readLine());

        int start = 0;
        int end = N-1;

        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == x){
                count++;
                start++;
                end--;
            }else if(sum > x){
                end--;
            }else{
                start++;
            }
        }

        System.out.println(count);

    }
}
