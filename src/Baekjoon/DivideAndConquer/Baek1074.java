package Baekjoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1074 {

    static int N, R, C, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        solution(0,0, (int) Math.pow(2,N));
        System.out.println(answer);
    }

    public static void solution(int x, int y, int size){

        if(size == 1 ){
            return;
        }

        int half = size/2;
        int count = (half * half); // 한 사분면에 포함된 칸 수

        if(R < x + half && C < y + half){ // 왼위
            solution(x, y, half);
        }else if(R < x + half && C >= y+ half){ //오위
            answer += count;
            solution(x, y+half, half);
        }else if(R >= x + half && C < y+ half) { //왼아;
            answer += count * 2;
            solution(x + half, y, half);
        }else{ //우아
            answer += count * 3;
            solution(x + half, y + half, half);
        }

    }
}
