package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지명선수_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] A = new int[N+1];
            int[] B = new int[N+1];
            char[] result = new char[N+1];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=1; i<N+1; i++){
                A[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=1; i<N+1; i++){
                B[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int aIndex = 1;
            int bIndex = 1;

            while (aIndex <= N || bIndex <= N) {
                while (aIndex <= N) {
                    if (result[A[aIndex]] == 0) {
                        result[A[aIndex]] = 'A';
                        aIndex++;
                        break;
                    } else {
                        aIndex++;
                    }
                }

                while (bIndex <= N) {
                    if (result[B[bIndex]] == 0) {
                        result[B[bIndex]] = 'B';
                        bIndex++;
                        break;
                    } else {
                        bIndex++;
                    }
                }
            }


            for(int i=1; i<N+1; i++){
                System.out.print(result[i]);
            }
            System.out.println();
        }
    }
}
