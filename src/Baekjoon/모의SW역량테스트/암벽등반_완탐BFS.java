package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 암벽등반_완탐BFS {
    static int N, M;
    static int[][] map;
    static int sx, sy, ex, ey;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 2) { sx = i; sy = j;}
                    else if(map[i][j] == 3) { ex = i; ey = j;}
                }
            }

            int answer = 0;
            for(int i=0; i<N; i++){
                if(BFS(i)){
                    answer = i;
                    break;
                }
            }

            System.out.println("#" + testCase + " " + answer);
        }
    }

    public static boolean BFS(int height){
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.offer(new Position(sx, sy));
        visited[sx][sy] = true;

        while(!queue.isEmpty()){
            Position current = queue.poll();

            if(current.x == ex && current.y == ey) return true;

            // 1. 좌우 이동
            // 1.1 왼쪽 이동
            if(current.y - 1 >= 0 && map[current.x][current.y-1] != 0 && !visited[current.x][current.y-1]){
                visited[current.x][current.y-1] = true;
                queue.offer(new Position(current.x, current.y-1));
            }
            // 1.2 오른쪽 이동
            if(current.y + 1 < M && map[current.x][current.y+1] != 0 && !visited[current.x][current.y+1]){
                visited[current.x][current.y+1] = true;
                queue.offer(new Position(current.x, current.y+1));
            }

            // 2. 상하 이동
            // 2.1 같은 열에서 다른 행으로 점프할 후보를 탐색
            for(int newX=0; newX<N; newX++){
                // 자기 자신으로 이동하려면 넘김
                if(newX == current.x) continue;
                if(Math.abs(newX - current.x) <= height && map[newX][current.y] != 0 && !visited[newX][current.y]){
                    visited[newX][current.y] = true;
                    queue.offer(new Position(newX, current.y));
                }
            }
        }

        return false;
    }

    public static class Position{
        int x;
        int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
