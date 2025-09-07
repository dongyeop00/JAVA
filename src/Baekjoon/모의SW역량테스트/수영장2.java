package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장2 {

    static int day, month, month3, year;
    static int min;
    static int[] schedule;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            month3 = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;

            schedule = new int[13];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<13; i++){
                schedule[i] = Integer.parseInt(st.nextToken());
            }

            solving(1, 0);
            min = Math.min(min, year);
            System.out.println("#" + testCase + " " + min);
        }
    }

    private static void solving(int currentMonth, int cost){
        if(cost >= min) return;

        if(currentMonth > 12){
            min = Math.min(cost, min);
            return;
        }

        solving(currentMonth+1, cost + schedule[currentMonth] * day);
        solving(currentMonth+1, cost + month);
        solving(currentMonth+3, cost + month3);
    }

}
