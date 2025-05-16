package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1_D4 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};
    static int arrivalX, arrivalY, result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(bufferedReader.readLine());

            map = new int[100][100];
            visited = new boolean[100][100];
            result = 0;

            for (int i = 0; i < 100; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            for (int i = 0; i < 100; i++) {
                if (map[99][i] == 2) {
                    arrivalX = 99;
                    arrivalY = i;
                    break;
                }
            }

            DFS(arrivalX, arrivalY);
            System.out.println("#" + T + " " + result);
        }
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        if (x == 0) {
            result = y;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < 100 && newY < 100) {
                if (map[newX][newY] == 1 && !visited[newX][newY]) {
                    DFS(newX, newY);
                    return; // 한 방향으로만 이동해야 함
                }
            }
        }
    }
}
