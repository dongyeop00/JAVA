package Baekjoon.Simulation;

import java.util.Scanner;

public class 보충학습과평균_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case<=T; test_case++){
            int sum = 0;

            for(int i=0; i<5; i++){
                int temp = sc.nextInt();

                if(temp <= 40){
                    temp = 40;
                }

                sum += temp;
            }

            int result = sum / 5;

            System.out.println("#" + test_case + " " + result);
        }
    }
}
