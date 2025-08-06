package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적경로 {

    static int N, min;
    static Position company, home;
    static Position[] customer, sel;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            N = Integer.parseInt(bufferedReader.readLine());
            visited = new boolean[N];
            customer = new Position[N];
            sel = new Position[N];
            min = Integer.MAX_VALUE;

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            company = new Position(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
            home = new Position(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));

            for(int i=0; i<N; i++){
                customer[i] = new Position(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
            }

            solution(0);
            System.out.println("#" + test_case + " " + min);
        }
    }

    public static void solution(int depth){
        if(depth == N){
            int sum = 0;
            //회사와 첫 좌표끼리의 거리
            sum += Math.abs(company.x - sel[0].x) + Math.abs(company.y - sel[0].y);
            for(int i=0; i<N-1; i++){
                sum += Math.abs(sel[i].x - sel[i+1].x) + Math.abs(sel[i].y - sel[i+1].y);
            }
            sum += Math.abs(sel[N-1].x - home.x) + Math.abs(sel[N-1].y - home.y);

            min = Math.min(sum, min);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                sel[depth] = customer[i];
                solution(depth+1);
                visited[i] = false;
            }
        }
    }

    public static class Position {
        int x;
        int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
