package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = 0, y = 0;

        for(int i = -999; i < 1000; i++){
            for(int j = -999; j < 1000; j++){
                if((a*i + b*j == c) && (d*i + e*j == f)){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        System.out.println(x + " " + y);
    }
}
