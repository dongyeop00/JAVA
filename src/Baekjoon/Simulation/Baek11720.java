package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        char[] c = str.toCharArray();
        int sum = 0;

        for(int i=0; i<N; i++){
            sum += c[i] - '0';
        }

        System.out.println(sum);
    }
}
