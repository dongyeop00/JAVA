package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이진수표현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            long mask = (1L << N) - 1;
            String ans = ((M & mask) == mask) ? "ON" : "OFF";

            System.out.println("#" + testCase + " " + ans);

        }
    }
}
