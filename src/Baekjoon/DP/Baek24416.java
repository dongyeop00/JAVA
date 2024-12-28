package Baekjoon.DP;

import java.util.Scanner;

public class Baek24416 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(fib(n) + " " + fibonacci(n));
    }

    private static int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }

    private static int fibonacci(int n){
        int count = 1;
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for(int i=3; i<n; i++){
            arr[i] = arr[i-1] + arr[i-2];
            count++;
        }
        return count;
    }
}
