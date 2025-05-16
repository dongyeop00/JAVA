package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 년2016요일맞추기_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int test_case = 1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int month = Integer.parseInt(stringTokenizer.nextToken());
            int day = Integer.parseInt(stringTokenizer.nextToken());
            int totalDay = 0;

            for(int i=0; i<month-1; i++){
                totalDay += days[i];
            }

            totalDay += day;
            int result = (totalDay+3) % 7;

            System.out.println("#" + test_case + " " + result);
        }
    }
}
