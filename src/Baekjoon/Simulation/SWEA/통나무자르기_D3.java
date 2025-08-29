package Baekjoon.Simulation.SWEA;

import java.util.Scanner;

public class 통나무자르기_D3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int N = scanner.nextInt();

            System.out.println("#" + test_case + " " + ( N % 2 == 0 ? "Alice" : "Bob"));
        }
    }
}
