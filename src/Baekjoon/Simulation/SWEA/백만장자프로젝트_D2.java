package Baekjoon.Simulation.SWEA;

import java.util.Scanner;

// 최대 N = 1,000,000
// 최대 가격 = 10,000
// 최대 이익은 (최대 매매가 - 최소 매매가) x N
// 최악의 경우 10,000 x 1,000,000 = 10,000,000,000 (100억)
// 따라서 자료형은 long

public class 백만장자프로젝트_D2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=1; i<=T; i++){
            int N = sc.nextInt();
            int[] array = new int[N];

            for(int j=0; j<N; j++){
                array[j] = sc.nextInt();
            }

            int max = array[N-1];
            long sum = 0;

            for(int k= N-2; k>=0; k--){
                if(max > array[k]){
                    sum += max - array[k];
                }else{
                    max = array[k];
                }
            }

            System.out.println("#" + i + " " + sum);
        }
    }
}
