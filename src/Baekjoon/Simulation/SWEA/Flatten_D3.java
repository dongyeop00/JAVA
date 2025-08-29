package Baekjoon.Simulation.SWEA;

import java.util.Scanner;

public class Flatten_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case<=10; test_case++){

            int dump = sc.nextInt();
            int[] map = new int[100];
            int maxIndex, minIndex;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for(int i=0; i<100; i++){
                map[i] = sc.nextInt();
            }

            for(int i=0; i<dump; i++){
                maxIndex = 0;
                minIndex = 0;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for(int j=0; j<100; j++){
                    if(max < map[j]){
                        maxIndex = j;
                        max = map[j];
                    }

                    if(min > map[j]){
                        minIndex = j;
                        min = map[j];
                    }
                }

                map[maxIndex] -= 1;
                map[minIndex] += 1;
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for(int i=0; i<100; i++){
                max = Math.max(max, map[i]);
                min = Math.min(min, map[i]);
            }

            System.out.println("#" + test_case + " " + (max - min));
        }
    }
}
