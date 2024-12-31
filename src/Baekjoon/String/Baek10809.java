package Baekjoon.String;

import java.util.Arrays;
import java.util.Scanner;

public class Baek10809 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        int[] count = new int[26];

        Arrays.fill(count, -1);

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (count[index] == -1) {
                count[index] = i;
            }
        }

        for(int i=0; i<count.length; i++){
            System.out.print(count[i] + " ");
        }

    }
}
