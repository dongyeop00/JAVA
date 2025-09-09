package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 암벽등반_이분탐색BFS {

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

            // 이분 탐색 범위 0 ~ N-1 (같은 행이면 0, 최악은 N-1)
            int low = 0, high = N-1, answer = high;
            while(low <= high){
                int mid = (low + high) / 2;
                if(BFS(mid)){ // min로 가능하면 더 줄인다.
                    answer = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
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

            if(current.x == ex && current.y == ey){
                return true;
            }

            // 1. 가로 이동
            // 1.1 왼쪽 이동(범위 안이거나 && 갈 수 있는 곳이거나 && 방문하지 않았거나)
            if(current.y - 1 >= 0 && map[current.x][current.y-1] != 0 && !visited[current.x][current.y-1]){
                visited[current.x][current.y-1] = true;
                queue.offer(new Position(current.x, current.y-1));
            }
            // 1.2 오른쪽 이동
            if(current.y + 1 < M && map[current.x][current.y+1] != 0 && !visited[current.x][current.y+1]){
                visited[current.x][current.y+1] = true;
                queue.offer(new Position(current.x, current.y+1));
            }

            // 2. 세로 이동
            for(int x=0; x<N; x++){
                if(x == current.x) continue;
                if(Math.abs(current.x - x) <= height && map[x][current.y] != 0 && !visited[x][current.y]){
                    visited[x][current.y] = true;
                    queue.offer(new Position(x, current.y));
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
