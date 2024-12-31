package Baekjoon.String;

import java.util.Scanner;

public class Baek1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.next();
        string = string.toUpperCase();
        int[] position = new int[26];
        int max = Integer.MIN_VALUE;
        int index = 0;
        int count = 0;

        for(int i=0; i<string.length(); i++){
            position[string.charAt(i) - 'A']++;
        }

        for(int i=0; i<position.length; i++){
            if(position[i] > max){
                index = i;
                max = position[i];
            }
        }

        for(int i=0; i<position.length; i++){
            if(max == position[i]){
                count++;
            }
        }

        if(count == 1){
            int c = 'A' + index;
            System.out.println((char)c);
        }else{
            System.out.println("?");
        }
    }
}
