package Baekjoon.String;

import java.util.Arrays;
import java.util.Scanner;

public class Baek1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        char[] arr = str.toCharArray();
        int[] result = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            result[i] = arr[i] - '0';
        }

        Arrays.sort(result);

        for(int i=result.length-1; i>=0; i--){
            System.out.print(result[i]);
        }

    }
}
