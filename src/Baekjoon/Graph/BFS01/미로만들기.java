package Baekjoon.Graph.BFS01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 미로만들기 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int result = BFS();
        System.out.println(result);
    }

    public static int BFS(){
        PriorityQueue<Position> queue = new PriorityQueue<>();

        queue.offer(new Position(0, 0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Position current = queue.poll();

            if(current.x == N-1 && current.y == N-1){
                return current.cost;
            }

            for(int i=0; i<4; i++){
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
                if(visited[newX][newY]) continue;

                visited[newX][newY] = true;

                if(map[newX][newY] == 0){
                    queue.offer(new Position(newX, newY, current.cost+1));
                }else{
                    queue.offer(new Position(newX, newY, current.cost));
                }
            }
        }

        return 0;
    }

    public static class Position implements Comparable<Position>{
        int x;
        int y;
        int cost;

        public Position(int x, int y, int cost) {
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
