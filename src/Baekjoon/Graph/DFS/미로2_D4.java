package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 미로2_D4 {

    static boolean[][] visited;
    static int[][] map;
    static int result;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 0; test_case <10; test_case++){
            int T = Integer.parseInt(bufferedReader.readLine());

            visited = new boolean[100][100];
            map = new int[100][100];

            for(int i=0; i<100; i++){
                String str = bufferedReader.readLine();
                for(int j=0; j<100; j++){
                    int temp = str.charAt(j) - '0';
                    map[i][j] = temp;
                }
            }

            result = 0;
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

            if(newX >= 0 && newY >= 0 && newX < 100 &&  newY < 100){
                if(map[newX][newY] != 1 && !visited[newX][newY]){
                    DFS(newX, newY);
                }
            }
        }
    }
}
