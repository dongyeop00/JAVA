package Baekjoon.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 산악구조로봇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = Dijkstra(N, map);
            System.out.println("#" + testCase + " " + result);
        }
    }

    public static int Dijkstra(int N, int[][] map){
        int INF = 1_000_000_000;
        PriorityQueue<Mountain> queue = new PriorityQueue<>();
        int[][] dist = new int[N][N];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i=0; i<N; i++){
            Arrays.fill(dist[i], INF);
        }

        queue.offer(new Mountain(0, 0, 0));
        dist[0][0] = 0;

        while(!queue.isEmpty()){
            Mountain current = queue.poll();

            if(current.cnt != dist[current.x][current.y]) continue;
            if(current.x == N-1 && current.y == N-1) return current.cnt;

            int currentCnt = map[current.x][current.y];

            for(int i=0; i<4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= N) continue;

                int newCnt = map[newX][newY];
                int moveCnt;

                if (newCnt == currentCnt) {
                    moveCnt = 1;
                } else if (newCnt < currentCnt) {
                    moveCnt = 0;
                } else {
                    moveCnt = (newCnt - currentCnt) * 2;
                }

                int next = current.cnt + moveCnt;
                if (next < dist[newX][newY]) {
                    dist[newX][newY] = next;
                    queue.offer(new Mountain(newX, newY, next));
                }
            }
        }
        return dist[N-1][N-1];
    }

    public static class Mountain implements Comparable<Mountain>{
        int x, y, cnt;

        Mountain(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Mountain o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }
}
