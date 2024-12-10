package Baekjoon.Step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2588 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());

        System.out.println(a * (b%10));
        System.out.println(a * ((b/10)%10));
        System.out.println(a * (b/100));
        System.out.println(a*b);
    }
}
