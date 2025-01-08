package Baekjoon.Simulation;

import java.util.Scanner;

public class Baek2577 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        long sum = (long) A *B*C;

        int[] countNumArray = new int[10];

        while(sum > 0){
            long temp = sum%10;
            sum/=10;
            countNumArray[(int)temp]++;
        }

        for(int i=0; i<10; i++){
            System.out.println(countNumArray[i]);
        }
    }
}
