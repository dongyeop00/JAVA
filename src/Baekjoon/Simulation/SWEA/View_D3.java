package Baekjoon.Simulation;

import java.util.Scanner;

public class View_D3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int i=1; i<=10; i++){
            int N = scanner.nextInt();
            int[] array = new int[N];
            int sum = 0;

            for(int j=0; j<N; j++){
                array[j] = scanner.nextInt();
            }

            for(int k=2; k<N-2; k++){
                int max = Math.max(array[k-2], Math.max(array[k-1], Math.max(array[k+1],array[k+2])));
                if(array[k] > max){
                    sum += array[k] - max;
                }
            }

            System.out.println("#" + i + " " + sum);
        }
    }
}
