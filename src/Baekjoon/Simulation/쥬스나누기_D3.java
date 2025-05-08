package Baekjoon.Simulation;

import java.util.Scanner;

public class 쥬스나누기_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int num = sc.nextInt();
            System.out.print("#" + test_case);
            for(int i=0; i<num; i++){
                System.out.print(" " + 1 + "/" + num);
            }
            System.out.println();
        }
    }
}
