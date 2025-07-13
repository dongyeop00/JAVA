package Baekjoon.Graph.DFS;

import java.io.*;
import java.util.*;

public class Baek11123 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int H, W;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 0; test_case<T; test_case++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            H = Integer.parseInt(stringTokenizer.nextToken());
            W = Integer.parseInt(stringTokenizer.nextToken());

            map = new int[H][W];
            visited = new boolean[H][W];
            int count = 0;

            for(int i=0; i<H; i++) {
                String str = bufferedReader.readLine();
                for(int j=0; j<W; j++) {
                    if(str.charAt(j) == '#') {
                        map[i][j] = 1;
                    }else {
                        map[i][j] = 0;
                    }
                }
            }


            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        DFS(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < H && newY < W) {
                if(map[newX][newY] == 1 && !visited[newX][newY]) {
                    DFS(newX, newY);
                }
            }
        }
    }

}

