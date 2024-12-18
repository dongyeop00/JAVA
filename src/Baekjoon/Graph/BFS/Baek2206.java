package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2206 {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; // [x][y][0]: 벽 안 부숨, [x][y][1]: 벽 부숨


        for(int i=0; i<N; i++){
            String string = bf.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = string.charAt(j) - '0';
            }
        }

        int result = BFS();
        System.out.println(result);
    }

    private static int BFS(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0,1,0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int currentX = point.x;
            int currentY = point.y;
            int currentDis = point.dis;
            int currentStatus = point.wallBroken;

            if(currentX == N-1 && currentY == M-1){
                return currentDis;
            }

            for(int i=0; i<4; i++) {
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    // 안부순 상태로 이동
                    if (map[newX][newY] == 0 && !visited[newX][newY][currentStatus]) {
                        queue.offer(new Point(newX, newY, currentDis + 1, currentStatus));
                        visited[newX][newY][currentStatus] = true;
                    }

                    // 부수고 이동
                    if(map[newX][newY] == 1 && !visited[newX][newY][1] && currentStatus == 0){
                        queue.offer(new Point(newX, newY, currentDis+1, 1));
                        visited[newX][newY][1] = true;
                    }
                }

            }
        }
        return -1;
    }

    private static class Point{
        int x;
        int y;
        int dis;
        int wallBroken;
        Point(int x, int y, int dis, int wallBroken){
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.wallBroken = wallBroken;
        }
    }
}
