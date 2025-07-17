package Baekjoon.Graph.DFS;
import java.io.*;
import java.util.*;

public class Baek17070 {

    static int N;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];
        result = 0;

        for(int i=0; i<N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        DFS(0, 1, 0);
        System.out.println(result);
    }

    private static void DFS(int x, int y, int direction) {
        if(x == (N-1) && y == (N-1)) {
            result++;
            return;
        }


        if(direction == 0) { // 가로
            if(y+1 < N && map[x][y+1] == 0) {
                DFS(x, y+1, 0); //가로로 이동
            }
        }else if(direction == 1) { //세로
            if(x+1 < N && map[x+1][y] == 0) {
                DFS(x+1, y, 1); //가로로 이동
            }
        }else if(direction == 2) { //대각선
            if(y+1 < N && map[x][y+1] == 0) { // 가로로 이동
                DFS(x, y+1, 0);
            }

            if(x+1 < N && map[x+1][y] == 0) { // 세로로 이동
                DFS(x+1, y, 1);
            }
        }

        if(x+1 < N && y+1 < N && map[x+1][y+1]==0 && map[x+1][y] == 0 && map[x][y+1] == 0) {
            DFS(x+1, y+1, 2);
        }
    }
}

