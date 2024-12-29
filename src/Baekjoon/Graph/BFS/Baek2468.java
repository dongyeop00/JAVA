package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2468 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, maxHeight = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }

        int answer = 1;

        for(int h=1; h<=maxHeight; h++){
            int count = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] > h && !visited[i][j]) {
                        BFS(i, j, h);
                        count++;
                    }
                }
            }
            answer = Math.max(count, answer);
        }

        System.out.println(answer);
    }

    private static void BFS(int x, int y, int h){
        Queue<Point> graph = new LinkedList<>();
        graph.offer(new Point(x,y));
        visited[x][y] = true;

        while(!graph.isEmpty()){
            Point point = graph.poll();
            int currentX = point.x;
            int currentY = point.y;

            for(int i=0; i<4; i++){
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                if(newX >= 0 && newY >= 0 && newX < N && newY < N){
                    if(map[newX][newY] > h && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        graph.offer(new Point(newX, newY));
                    }
                }
            }
        }
    }

    private static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
