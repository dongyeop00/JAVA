package Baekjoon.Simulation;

import java.util.Scanner;

public class Summation_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i=0; i<10; i++){
                int num = cal(sc.nextInt());
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            System.out.println("#" + test_case + " " + max + " " + min);
        }
    }

    private static int cal(int num){
       int sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
