package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 산악구조로봇 {

    static final int INF = 1_000_000_000;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

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

            int result = dijkstra(map, N);
            System.out.println("#" + testCase + " " + result);
        }
    }

    public static int dijkstra(int[][] map, int N){
        int[][] dist = new int[N][N]; //최소 저장용 배열
        // 처음에는 무한대로 초기화
        for(int[] row : dist){
            Arrays.fill(row, INF);
        }

        PriorityQueue<Position> queue = new PriorityQueue<>();
        dist[0][0] = 0;
        queue.offer(new Position(0, 0, 0));

        // 다익스트라 탐색
        while(!queue.isEmpty()){
            Position current = queue.poll();

            // 이미 더 작은 비용이 있으면 무시
            if(current.cost != dist[current.x][current.y]) continue;

            // 도착점 도착하면 리턴
            if(current.x == N-1 && current.y == N-1) return current.cost;

            // 현재 칸의 높이
            int height = map[current.x][current.y];

            // 상하좌우 이동
            for(int i=0; i<4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                //범위 벗어나면 무시
                if (newX < 0 || newY < 0 || newX >= N || newY >= N) continue;

                // 다음 칸 높이
                int newH = map[newX][newY];
                int moveCost;

                if (newH == height) { // 다음 높이가 같으면 비용 1
                    moveCost = 1;
                } else if (newH < height) { // 다음 높이가 낮으면 비용 0
                    moveCost = 0;
                } else { // 다음 높이가 높으면 *2
                    moveCost = (newH - height) * 2;
                }

                // 더 적은 비용으로 갱신 가능하면 갱신
                int next = current.cost + moveCost;
                if (next < dist[newX][newY]) {
                    dist[newX][newY] = next;
                    queue.offer(new Position(newX, newY, next));
                }
            }
        }
        return dist[N-1][N-1];
    }

    static class Position implements Comparable<Position>{
        int x;
        int y;
        int cost;

        Position(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Position o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
