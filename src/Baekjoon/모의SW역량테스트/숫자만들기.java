package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자만들기 {

    static int min, max;
    static int N;
    static boolean[] selected;
    static int[] number;
    static int[] operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            N = Integer.parseInt(br.readLine());
            operator = new int[4];
            number = new int[N];
            selected = new boolean[N];
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                operator[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                number[i] = Integer.parseInt(st.nextToken());
            }

            DFS(1, number[0], operator[0], operator[1], operator[2], operator[3]);
            System.out.println("#" + testCase + " " + (max - min));
        }
    }

    public static void DFS(int depth, int sum, int plus, int minus, int mul, int div){
        if(depth == N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        if(plus > 0) DFS(depth+1, sum + number[depth], plus-1, minus, mul, div);
        if(minus > 0) DFS(depth+1, sum - number[depth], plus, minus -1, mul, div);
        if(mul > 0) DFS(depth+1, sum * number[depth], plus, minus, mul-1, div);
        if(div > 0) DFS(depth+1, sum / number[depth], plus, minus, mul, div-1);
    }
}
