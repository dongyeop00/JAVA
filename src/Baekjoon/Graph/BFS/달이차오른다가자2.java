package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다가자2 {

    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    static Position start;
    static Position end;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[64][N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0') start = new Position(i, j);
                if(map[i][j] == '1') end = new Position(i, j);
            }
        }

        int result = BFS(start.x, start.y);
        System.out.println(result);
    }

    public static int BFS(int x, int y){
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y, 0, 0));
        visited[0][x][y] = true;

        while(!queue.isEmpty()){
            Position current = queue.poll();

            if(map[current.x][current.y] == '1'){
                return current.dist;
            }

            for(int i=0; i<4; i++){
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                int newKey = current.key;

                if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;

                char cell = map[newX][newY];
                if(cell == '#') continue;

                // 다음칸 열쇠면 열쇠 줍기
                if('a' <= cell && cell <= 'f'){
                    newKey = newKey | (1 << (cell - 'a'));
                }

                // 다음칸 문이면 열쇠 확인
                if('A' <= cell && cell <= 'F'){
                    int door = 1 << (cell - 'A');
                    if((newKey & door) == 0 ) continue;
                }

                // 이동
                if(!visited[newKey][newX][newY]){
                    visited[newKey][newX][newY] = true;
                    queue.offer(new Position(newX, newY, current.dist+1, newKey));
                }
            }
        }

        return -1;
    }

    public static class Position{
        int x;
        int y;
        int dist;
        int key;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        Position(int x, int y, int dist, int key){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.key = key;
        }
    }
}
