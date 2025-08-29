package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백만장자프로젝트2_D2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());

            int[] array = new int[N];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<N; i++){
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int max = array[N-1];
            long sum = 0;

            for(int i=N-2; i>=0; i--){
                if(max > array[i]){
                    sum += max- array[i];
                }else{
                    max = array[i];
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }

    }
}
