package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2468 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int count, N;
    static int maxHeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }

        int answer = 1;

        for(int h=1; h <=maxHeight; h++) {
            count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        DFS(i, j, h);
                        count++;
                    }
                }
            }
            answer = Math.max(count, answer);
        }

        System.out.println(answer);
    }

    private static void DFS(int x, int y, int h){
        if(!visited[x][y]){
            visited[x][y] = true;
        }

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < N && newY < N ){
                if(map[newX][newY] > h && !visited[newX][newY]){
                    DFS(newX,newY, h);
                }
            }
        }
    }
}
