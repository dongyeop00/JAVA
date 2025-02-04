package Baekjoon.Simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Baek1475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static int solution(String x){
        int[] number = new int[10];

        for(int i = 0; i < x.length(); i++) {
            int temp = x.charAt(i) - '0';

            if(temp == 6) temp = 9;

            number[temp]++;
        }

        number[9] = (number[9] + 1) / 2;

        Arrays.sort(number);

        return number[9];
    }
}
