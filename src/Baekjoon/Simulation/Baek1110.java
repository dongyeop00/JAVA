package Baekjoon.Simulation;

import java.util.Scanner;

public class Baek1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int answer = N;
        int count = 0;

        while(true){
            int ten, one, newOne;
            if(N < 10){
                ten = 0;
                one = N;
            }else{
                ten = N/10;
                one = N%10;
            }

            if(ten+one >= 10){
                newOne = (ten+one)%10;
            }else{
                newOne = ten+one;
            }

            N = one*10 + newOne;
            count++;

            if(N == answer) {
                System.out.println(count );
                break;
            }
        }
    }
}
