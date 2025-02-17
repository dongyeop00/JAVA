package Baekjoon.Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}};

        boolean[][] visited = new boolean[maps.length][maps[0].length];

        System.out.println(bfs(maps, visited, maps.length, maps[0].length));
    }

    private static int bfs(int[][] maps, boolean[][] visited, int x, int y){
        Queue<Current> queue = new LinkedList<>();
        queue.offer(new Current(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Current c = queue.poll();
            int currentX = c.x;
            int currentY = c.y;
            int currentDistance = c.distacne;

            if(currentX == x-1 && currentY == y-1){
                return currentDistance;
            }

            for(int i=0; i<4; i++){
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                if(newX >= 0 && newY >= 0 && newX < x && newY < y){
                    if(maps[newX][newY] == 1 && !visited[newX][newY]){
                        queue.offer(new Current(newX, newY, currentDistance+1));
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        return -1;
    }

    private static class Current{
        int x, y, distacne;
        Current(int x, int y, int distacne){
            this.x = x;
            this.y = y;
            this.distacne = distacne;
        }
    }
}
