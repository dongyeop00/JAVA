package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1926 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxWidth = Integer.MIN_VALUE;
    static int countPaint, width;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && !visited[i][j]) {
                    width = 0;
                    BFS(i,j);
                    countPaint++;
                    maxWidth = Math.max(maxWidth, width);
                }
            }
        }

        if(countPaint == 0 ){
            maxWidth = 0;
        }

        System.out.println(countPaint);
        System.out.println(maxWidth);
    }

    private static void BFS(int x, int y){
        width = 1;
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

                if(newX >= 0 && newY >= 0 && newX < n && newY < m){
                    if(map[newX][newY] == 1 && !visited[newX][newY]){
                        graph.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
                        width++;
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
