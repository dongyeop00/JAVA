package Baekjoon.Simulation;

import java.util.Scanner;

public class 팩토리얼 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        if(N == 0){
            System.out.println(1);
            return;
        }else{
            System.out.println(fact(N));
        }
    }

    private static int fact(int temp){
        int num = 1;

        for(int i=temp; i>0; i--){
            num *= i;
        }

        return num;
    }
}
