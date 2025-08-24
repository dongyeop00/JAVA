package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 새로운불면증치료법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            int N = Integer.parseInt(br.readLine());
            int want = (1 << 10) - 1;
            int bitmask = 0;
            int count = 0;
            int value = 0;

            while(bitmask != want){
                count++;
                value = N * count;

                int x = value;
                while(x > 0){
                    bitmask |= 1 << (x % 10);
                    x /= 10;
                }
            }

            System.out.println("#" + testCase + " " + value);
        }
    }
}
