package Baekjoon.String;

import java.util.Arrays;
import java.util.Scanner;

public class Baek1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        String[] array = str.split("-");

        int sum = Integer.MAX_VALUE;
        for(int i=0; i<array.length; i++){
            int temp = 0;

            String[] arrayTemp = array[i].split("\\+");

            for(int j=0; j<arrayTemp.length; j++){
                temp += Integer.parseInt(arrayTemp[j]);
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
