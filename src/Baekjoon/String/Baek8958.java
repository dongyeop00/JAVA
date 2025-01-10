package Baekjoon.String;

import java.util.Scanner;

public class Baek8958 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for(int i=0; i<testCase; i++){
            String str = scanner.next();
            System.out.println(checkScore(str));
        }
    }

    private static int checkScore(String str){
        int count = 0;
        int sum = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'O'){
                count++;
            }else{
                count = 0;
            }
            sum += count;
        }

        return sum;
    }
}
