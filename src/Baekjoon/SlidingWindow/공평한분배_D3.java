package Baekjoon.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class 공평한분배_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case<=T; test_case++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int result = Integer.MAX_VALUE;

            int[] array = new int[N];

            for(int i=0; i<N; i++){
                array[i] = sc.nextInt();
            }

            Arrays.sort(array);

            for(int i=0; i<=N-K; i++){ //슬라이딩 회수
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int j=i; j<i+K; j++){ //슬라이딩 크기
                    min = Math.min(min, array[j]);
                    max = Math.max(max, array[j]);
                }
                int sum = max - min;
                result = Math.min(sum, result);
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
