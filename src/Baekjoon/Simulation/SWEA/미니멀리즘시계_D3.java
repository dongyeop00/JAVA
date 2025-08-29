package Baekjoon.Simulation.SWEA;

import java.util.Scanner;

public class 미니멀리즘시계_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            N *= 2;

            int hour = 0, min = 0;

            hour = N / 60;
            min = N % 60;

            System.out.println("#" + test_case + " " + hour + " " + min);
        }
    }
}