package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수영대회결승전 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Position start, end;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            start = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int result = BFS();

            System.out.println("#" + testCase + " " + result);
        }
    }

    public static int BFS() {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(start.x, start.y));
        visited[start.x][start.y] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position current = queue.poll();

                if (current.x == end.x && current.y == end.y) return time;

                for (int j = 0; j < 4; j++) {
                    int newX = current.x + dx[j];
                    int newY = current.y + dy[j];

                    if (newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
                    if (visited[newX][newY]) continue;
                    if (map[newX][newY] == 1) continue;

                    visited[current.x][current.y] = true;

                    // 소용돌이 없어지는 구간 2, 5, 8, 10...
                    // 다음칸이 소용돌이고, 소용돌이가 없어지는 시간이 아니라면 기다림
                    if (map[newX][newY] == 2 && time % 3 != 2) {
                        queue.offer(new Position(current.x, current.y));
                    }
                    // 지나갈 수 있는 곳 다 넣음
                    else {
                        queue.offer(new Position(newX, newY));
                    }
                }
            }
            time++;
        }
        return -1;
    }

    private static class Position{
        int x;
        int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
