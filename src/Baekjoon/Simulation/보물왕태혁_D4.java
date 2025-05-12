package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보물왕태혁_D4 {
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

            Arrays.sort(array);
            int result = 0;
            if(array.length > 1){
                result = array[0] * array[array.length-1];
            }else{
                result = array[0] * array[0];
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
