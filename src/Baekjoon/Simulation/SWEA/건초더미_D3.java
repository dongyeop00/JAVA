package Baekjoon.Simulation.SWEA;

import java.util.Scanner;

public class 건초더미_D3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for(int test_case=1; test_case<=T; test_case++){
            int N = scanner.nextInt();
            int[] array = new int[N];
            int avg = 0;
            int count = 0;

            for(int i=0; i<N; i++){
                array[i] = scanner.nextInt();
                avg += array[i];
            }

            avg /= N;
            for(int i=0; i<N; i++){
                if(array[i] > avg){
                    count += array[i] - avg;
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
