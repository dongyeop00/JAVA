package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 미로1_D4 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case<=10; test_case++){
            int T = Integer.parseInt(bufferedReader.readLine());

            map = new int[16][16];
            visited = new boolean[16][16];
            result = 0;

            for(int i=0; i<16; i++){
                String str = bufferedReader.readLine();
                for(int j=0; j<16; j++){
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            DFS(1,1);
            System.out.println("#" + T + " " + result);
        }
    }

    private static void DFS(int x, int y){
        visited[x][y] = true;

        if(map[x][y] == 3){
            result = 1;
            return;
        }

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

        }
    }
}
