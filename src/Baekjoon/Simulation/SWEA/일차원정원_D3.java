package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일차원정원_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int D = Integer.parseInt(stringTokenizer.nextToken());

            int water = D*2+1;

            if(N/water == 0){
                System.out.println("#" + test_case + " " + 1);
            }else if(N%water > 0){
                int result = N/water+1;
                System.out.println("#" + test_case + " " + result);
            }else{
                int result = N/water;
                System.out.println("#" + test_case + " " + result);
            }
        }
    }
}
