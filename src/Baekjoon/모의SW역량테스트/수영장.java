package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수영장 {

    static int day, month, month3, year;
    static int[] map;

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

            st = new StringTokenizer(br.readLine());
            map = new int[13];

            for(int i=1; i<13; i++){
                map[i] = Integer.parseInt(st.nextToken());
            }

            int result = Math.min(year, dfs(1));
            System.out.println("#" + testCase + " " + result);
        }
    }

    public static int dfs(int m){
        if(m > 12) return 0;
        if(map[m] == 0) return dfs(m+1);

        int costThisMonth = Math.min(map[m] * day, month) + dfs(m+1);
        int threeMonth = month3 + dfs(m+3);

        return Math.min(costThisMonth, threeMonth);
    }
}
