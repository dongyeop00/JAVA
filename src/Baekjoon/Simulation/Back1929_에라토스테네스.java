package Baekjoon.Simulation;

import java.util.Scanner;

public class Back1929_에라토스테네스 {

    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        arr = new int[N+1];

        checkPrim(M, N);

        for(int i=M; i<=N; i++){
            if(arr[i] != 0){
                System.out.println(arr[i]);
            }
        }
    }

    private static void checkPrim(int M, int N){

        // 숫자를 채운다.
        for(int i=2; i<=N; i++){
            arr[i] = i;
        }

        //자신을 제외한 배수 삭제
        for(int i=2; i <= N; i++){
            if(arr[i] == 0){
                continue;
            }

            for(int j=i+i; j<=N; j+=i){
                arr[j] = 0;
            }
        }
    }
}
