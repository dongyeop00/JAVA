package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14888 {

    static int[] operation;
    static int[] num;
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        num = new int[N];
        operation = new int[4];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=0; i<4; i++){
            operation[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        backTracking(num[0],0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void backTracking(int currentResult, int depth){

        if(depth == N-1){
            min = Math.min(currentResult, min);
            max = Math.max(currentResult, max);
            return;
        }

        for(int i=0; i<4; i++){
            if(operation[i] > 0){
                operation[i] -= 1;

                switch (i){
                    case 0:
                        backTracking(currentResult + num[depth+1], depth+1);
                        break;
                    case 1:
                        backTracking(currentResult - num[depth+1], depth+1);
                        break;
                    case 2:
                        backTracking(currentResult * num[depth+1], depth+1);
                        break;
                    case 3:
                        backTracking(currentResult / num[depth+1], depth+1);
                        break;
                }

                operation[i] += 1;
            }
        }
    }
}
