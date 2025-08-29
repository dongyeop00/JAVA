package Baekjoon.Simulation.SWEA;

import java.util.Scanner;

public class 쉽게푸는문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int[] arr = new int[1001];
        int tot=0, count=0;
        for(int i=1; i<B+1; i++){
            for(int j=1; j<=i; j++){
                if(count >= arr.length-1)
                    break;
                arr[count]=i;
                count++;

            }
        }

        for(int j=A-1; j<=B-1; j++){
            tot += arr[j];
        }

        System.out.println(tot);
    }
}
