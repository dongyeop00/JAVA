package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 현주의상자바꾸기_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int Q = Integer.parseInt(stringTokenizer.nextToken());

            int[] array = new int[N];
            int index = 1;
            for(int i=0; i<Q; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int L = Integer.parseInt(stringTokenizer.nextToken());
                int R = Integer.parseInt(stringTokenizer.nextToken());

                for(int j=L-1; j<R; j++){
                    array[j] = index;
                }
                index++;
            }

            System.out.print("#" + test_case + " ");
            for(int num : array){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
