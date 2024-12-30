package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek4963 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int count, w, h;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            w = Integer.parseInt(stringTokenizer.nextToken());
            h = Integer.parseInt(stringTokenizer.nextToken());

            if(w == 0 || h == 0){
                break;
            }

            count = 0;
            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        BFS(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int currentX = point.x;
            int currentY = point.y;

            for(int i=0; i<8; i++){
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                if(newX >= 0 && newY >= 0 && newX < h && newY < w){
                    if(map[newX][newY] == 1 && !visited[newX][newY]){
                        queue.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
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
