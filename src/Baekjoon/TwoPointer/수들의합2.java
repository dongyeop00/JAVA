package Baekjoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2 {

    static int N, M, count;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        num = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        twoPoint();
        System.out.println(count);
    }

    private static void twoPoint(){
        int start = 0, end = 0;
        int sum = 0;

        while(true){
            if(sum >= M){
                sum -= num[start++];
            }else if(end == N){
                break;
            }else{
                sum += num[end++];
            }

            if(sum == M){
                count++;
            }
        }
    }
}
