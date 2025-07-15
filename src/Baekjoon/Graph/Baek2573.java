package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2573 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int year = 0;

        while(true){
            year++;
            int count = 0;
            visited = new boolean[N][M];

            //빙하 녹기
            afterYear();

            //분리 확인
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] != 0 && !visited[i][j]){
                        checkIce(i,j);
                        count++;
                    }
                }
            }

            if (count == 0) { // 모두 녹았는데 분리되지 않음
                System.out.println(0);
                return;
            }

            if (count >= 2) { // 빙산이 분리됨
                System.out.println(year);
                return;
            }
        }

    }

    private static void afterYear(){
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0){
                    queue.offer(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            Point current = queue.poll();

            int count = 0;
            for(int i=0; i<4; i++){
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if(newX >= 0 && newY >= 0 && newX < N && newY < M){
                    if(!visited[newX][newY] && map[newX][newY] == 0){
                        count++;
                    }
                }
            }

            int temp = map[current.x][current.y] - count;
            if(temp <= 0){
                map[current.x][current.y] = 0;
            }else{
                map[current.x][current.y] = temp;
            }
        }
    }

    private static void checkIce(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < N && newY < M){
                if(!visited[newX][newY] && map[newX][newY] != 0){
                    checkIce(newX, newY);
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
