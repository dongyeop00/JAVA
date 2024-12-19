package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int testCase = Integer.parseInt(bufferedReader.readLine());
        boolean[][] visited = new boolean[101][101];
        int total = 0;

        for(int t=0; t<testCase; t++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            for(int i=x; i<x+10; i++){
                for(int j=y; j<y+10; j++){
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        total++;
                    }
                }
            }
        }
        System.out.println(total);

    }
}
