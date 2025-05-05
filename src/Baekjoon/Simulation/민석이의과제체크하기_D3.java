package Baekjoon.Simulation;

import java.util.Scanner;

public class 민석이의과제체크하기_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] array = new int[N+1];
            for(int i=1; i<=K; i++){
                int temp = sc.nextInt();
                array[temp] = 1;
            }

            System.out.print("#" + test_case);
            for(int i=1; i<=N; i++){
                if(array[i] == 0){
                    System.out.print(" " + i);
                }
            }

            System.out.println();
        }
    }
}
