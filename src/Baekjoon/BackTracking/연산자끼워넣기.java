package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int N;
    static int[] operators;
    static int[] number;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        number = new int[N];
        operators = new int[4];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++){
            number[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<4; i++){
            operators[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        backTracking(0, number[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void backTracking(int depth, int sum){
        if(depth == N-1){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i=0; i<4; i++){
            if(operators[i] > 0){
                operators[i] -= 1;

                if(i == 0){
                    backTracking(depth+1, sum + number[depth+1]);
                }else if(i == 1){
                    backTracking(depth+1, sum - number[depth+1]);
                }else if(i == 2){
                    backTracking(depth+1, sum * number[depth+1]);
                }else{
                    backTracking(depth+1, sum / number[depth+1]);
                }

                operators[i] += 1;
            }
        }
    }

}
