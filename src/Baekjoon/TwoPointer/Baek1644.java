package Baekjoon.TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class Baek1644 {

    static int N, count;
    static int[] num;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        num = new int[N];
        int index = 0;

        for(int i=2; i<=N; i++){
            if(isPrime(i)){
                num[index] = i;
                index++;
            }
        }


        twoPointer();
        /*
        if(isPrime(N)){
            System.out.println(count+1);
        }else{
            System.out.println(count);
        }
         */
        System.out.println(count);
    }

    private static void twoPointer(){
        int start = 0, end = 0, sum = 0;

        while(true){
            if( sum >= N){
                sum -= num[start++];
            }else if(num[end] == 0){
                break;
            }else{
                sum += num[end++];
            }

            if(sum == N){
                count++;
            }
        }
    }

    private static boolean isPrime(int num){
        if(num<2){
            return false;
        }

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }

        return true;
    }


}
