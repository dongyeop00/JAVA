package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장애물경주난이도_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case<=T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] array = new int[N];
            int up = 0;
            int down = 0;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for(int i=0; i<N; i++){
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for(int i=0; i<N-1; i++){
                if(array[i] < array[i+1]){
                    int temp = array[i+1] - array[i];
                    up = Math.max(temp,up);
                }else{
                    int temp = array[i] - array[i+1];
                    down = Math.max(temp, down);
                }

            }

            System.out.println("#"+test_case+" "+up+" "+down);
        }
    }
}
