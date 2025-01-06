package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1926 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int countPaint, width;
    static int maxWidth = Integer.MIN_VALUE;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    width = 1;
                    DFS(i,j);
                    maxWidth = Math.max(maxWidth, width);
                    countPaint++;
                }
            }
        }

        if(countPaint == 0){
            maxWidth = 0;
        }

        System.out.println(countPaint + "\n" + maxWidth);
    }

    private static void DFS(int x, int y){
        if(!visited[x][y]){
            visited[x][y] = true;
        }

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < n && newY < m){
                if(map[newX][newY] == 1 && !visited[newX][newY]){
                    DFS(newX, newY);
                    width++;
                }
            }
        }
    }
}
