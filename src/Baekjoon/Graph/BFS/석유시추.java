package Baekjoon.Graph.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 석유시추 {
    static int[][] land;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int x, y;
    static int[] oils;

    public static void main(String[] args) {
        land = new int[][]{
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };

        int answer = 0;
        x = land.length;
        y = land[0].length;
        visited = new boolean[x][y];
        oils = new int[y];

        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if(land[j][i] == 1 && !visited[j][i]){
                    bfs(j,i);
                }
            }
        }

        for(int num : oils){
            answer = Math.max(answer, num);
        }

        System.out.println(answer);
    }

    private static void bfs(int a, int b){
        Queue<Position> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(new Position(a,b));
        visited[a][b] = true;
        int count = 1;

        while(!queue.isEmpty()){
            Position position = queue.poll();
            int currentX = position.x;
            int currentY = position.y;
            set.add(currentY);

            for(int i=0; i<4; i++){
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                if(newX >= 0 && newY >= 0 && newX < x && newY < y){
                    if(land[newX][newY] == 1 && !visited[newX][newY]){
                        queue.offer(new Position(newX, newY));
                        visited[newX][newY] = true;
                        count++;
                    }
                }
            }
        }

        for(int num : set) {
            oils[num] += count;
        }
    }

    private static class Position{
        int x, y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

