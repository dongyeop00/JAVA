package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 디저트카페 {

    static int N, result;
    static int[][] map;
    static boolean[][] visited;
    static boolean[] desert;
    // ↗ ↘ ↙ ↖
    static int[] dx = {-1, 1, 1, -1};
    static int[] dy = {1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = -1;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    visited = new boolean[N][N];
                    desert = new boolean[101];

                    visited[i][j] = true;
                    desert[map[i][j]] = true;
                    dfs(i, j, i, j, 0, 1);
                }
            }

            System.out.println("#" + testCase + " " + result);
        }
    }

    public static void dfs(int sx, int sy, int x, int y, int dir, int cnt){
        // 직진 or 한번 꺾기만 가능함
        for(int i=0; i<2; i++){
            int newDir = dir + i;
            if(newDir >= 4) continue;

            int newX = x + dx[newDir];
            int newY = y + dy[newDir];

            if(newX < 0 || newY < 0 || newX >= N || newY >= N ) continue;

            if(newX == sx && newY == sy){
                result = Math.max(cnt, result);
                continue;
            }

            int d = map[newX][newY];

            if(!visited[newX][newY] && !desert[d]){
                visited[newX][newY] = true;
                desert[d] = true;

                dfs(sx, sy, newX, newY, newDir, cnt+1);

                visited[newX][newY] = false;
                desert[d] = false;
            }
        }
    }
}
