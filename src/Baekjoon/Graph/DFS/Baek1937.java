package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1937 {

    static int N;
    static int[][] map, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];
        dp = new int[N][N];

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int result = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result = Math.max(result, DFS(i,j));
            }
        }

        System.out.println(result);
    }

    public static int DFS(int x, int y){
        if(dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < N && newY < N){
                if(map[newX][newY] > map[x][y]){
                    dp[x][y] = Math.max(dp[x][y], DFS(newX, newY)+1);
                }
            }
        }

        return dp[x][y];
    }

}
