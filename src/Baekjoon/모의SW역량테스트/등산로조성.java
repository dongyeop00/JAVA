package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 등산로조성 {

    static int N, K, maxLen;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            List<Mountain> mountainList = new ArrayList<>();
            map = new int[N][N];
            visited = new boolean[N][N];
            maxLen = Integer.MIN_VALUE;
            int max = 0;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(map[i][j], max);
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == max){
                        mountainList.add(new Mountain(i, j));
                    }
                }
            }

            for(Mountain m : mountainList){
                visited[m.x][m.y] = true;
                DFS(m.x, m.y, 1, false);
                visited[m.x][m.y] = false;
            }

            System.out.println("#" + testCase + " " + maxLen);
        }
    }

    public static void DFS(int x, int y, int cnt, boolean cut){
        maxLen = Math.max(cnt, maxLen);

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
            if(visited[newX][newY]) continue;

            // 그냥 이동할 수 있을 때
            if (map[newX][newY] < map[x][y]) {
                visited[newX][newY] = true;
                DFS(newX, newY, cnt+1, cut);
                visited[newX][newY] = false;
            }else if(!cut && map[newX][newY] - K < map[x][y]){ // 1번 자르지 않았고, k만큼 빼면 이동할 수 있을 때
                int originValue = map[newX][newY];
                map[newX][newY] = map[x][y] - 1;
                visited[newX][newY] = true;
                DFS(newX, newY, cnt+1, true);
                visited[newX][newY] = false;
                map[newX][newY] = originValue;
            }
        }
    }

    static class Mountain{
        int x;
        int y;

        Mountain(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
