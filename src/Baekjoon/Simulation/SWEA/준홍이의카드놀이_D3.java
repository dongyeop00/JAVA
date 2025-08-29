package Baekjoon.Simulation.SWEA;

import java.util.Scanner;

public class 준홍이의카드놀이_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] array = new int[N+M+1];

            for(int i=1; i<=N; i++){
                for(int j=1; j<=M; j++){
                    array[i+j]++;
                }
            }

            int max = 0;

            for(int i=1; i<=N+M; i++){
                max = Math.max(max, array[i]);
            }

            System.out.print("#" + test_case);
            for(int i=1; i<=N+M; i++){
                if(array[i] == max){
                    System.out.print(" " + i);
                }
            }
            System.out.println();
        }
    }
}
