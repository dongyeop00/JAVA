package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 태혁이의사랑은타이밍_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int D = Integer.parseInt(stringTokenizer.nextToken());
            int H = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int eventDay = 11 * 24 * 60 + 11 * 60 + 11;
            int currentDay = D * 24 * 60 + H * 60 + M;

            int result = currentDay - eventDay;

            if (result < 0) {
                System.out.println("#" + test_case + " " + -1);
            } else {
                System.out.println("#" + test_case + " " + result);
            }
        }
    }
}
