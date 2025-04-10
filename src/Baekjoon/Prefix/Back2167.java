package Baekjoon.Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.
 */
public class Back2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(bf.readLine());

        for(int i=0; i<K; i++){
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken()); //1
            int b = Integer.parseInt(st.nextToken()); //1
            int x = Integer.parseInt(st.nextToken()); //2
            int y = Integer.parseInt(st.nextToken()); //3
            int sum = 0;

            for(int row = a-1; row<x; row++){
                for(int col = b-1; col<y; col++){
                    sum += map[row][col];
                }
            }

            System.out.println(sum);
        }
    }
}
