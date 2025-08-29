package Baekjoon.Simulation.SWEA;

import java.io.*;
import java.util.*;

public class  두개의숫자열_D2 {
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<N; i++) {
                A[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<M; i++) {
                B[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int result = 0;

            if(N < M) {
                result = method(A, B, M-N+1, N, 0);
            }else if(N > M){
                result = method(A, B, N-M+1, M, 1);
            }else {
                result = 0;
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

    public static int method(int[] A, int[] B, int windowSize, int multSize, int mode) {
        int startIndex = 0;
        int si = 1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int temp = 0;

        if(mode == 0) {
            for(int i=0; i<windowSize; i++) {
                for(int j=0; j<multSize; j++) {
                    sum += A[temp++] * B[startIndex++];
                }

                max = Math.max(sum, max);
                temp = 0;
                startIndex = si++;
                sum = 0;
            }
        }else {
            for(int i=0; i<windowSize; i++) {
                for(int j=0; j<multSize; j++) {
                    sum += B[temp++] * A[startIndex++];
                }

                max = Math.max(sum, max);
                temp = 0;
                startIndex = si++;
                sum = 0;
            }
        }

        return max;
    }
}
