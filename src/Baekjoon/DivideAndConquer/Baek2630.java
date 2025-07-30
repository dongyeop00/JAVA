package Baekjoon.DivideAndConquer;

import java.util.*;
import java.io.*;

public class Baek2630 {

    static int N;
    static int blue, white;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        make(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void make(int x, int y, int size) {
        int w = 0;
        int b = 0;

        if(size==0) {
            return;
        }

        for(int i=x; i<size+x; i++) {
            for(int j=y; j<size+y; j++) {
                if(map[i][j] == 1) {
                    b++;
                }else {
                    w++;
                }
            }
        }

        if(b==0) {
            white++;
            return;
        }

        if(w==0) {
            blue++;
            return;
        }

        make(x, y, size/2); //1사분면
        make(x+size/2, y, size/2); //2사분면
        make(x, y+size/2, size/2); //3사분면
        make(x+size/2, y+size/2, size/2); //4사분면
    }
}
