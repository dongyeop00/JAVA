package Baekjoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기 {

    static int N, white, blue;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        white = 0;
        blue = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Divide(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void Divide(int x, int y, int size){
        int w = 0;
        int b = 0;

        for(int i=x; i<size+x; i++){
            for(int j=y; j<size+y; j++){
                if(map[i][j] == 1) b++;
                else w++;
            }
        }

        if(b == 0){
            white++;
            return;
        }

        if(w == 0){
            blue++;
            return;
        }

        // 1사분면
        Divide(x, y, size/2);
        // 2사분면
        Divide(x+size/2, y, size/2);
        // 3사분면
        Divide(x, y+size/2, size/2);
        // 4사분면
        Divide(x+size/2, y+size/2, size/2);
    }
}