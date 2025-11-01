package Baekjoon.달리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다가자 {

    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    static int sx, sy, ex, ey;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][64]; // 2 ^ 6 (a,b,c,d,e,f)

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0'){
                    sx = i;
                    sy = j;
                }else if(map[i][j] == '1'){
                    ex = i;
                    ey = j;
                }
            }
        }

        int result = BFS(sx, sy);
        System.out.println(result);
    }

    public static int BFS(int x, int y){
        Queue<Position> queue = new LinkedList<>();

        queue.offer(new Position(x, y, 0, 0));
        visited[x][y][0] = true;

        while(!queue.isEmpty()){
            Position current= queue.poll();

            if(map[current.x][current.y] == '1'){
                return current.dist;
            }

            for(int d=0; d<4; d++){
                int newX = current.x + dx[d];
                int newY = current.y + dy[d];

                if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                if(map[newX][newY] == '#') continue;

                char temp = map[newX][newY];
                int newKey = current.key;

                // 열쇠라면?
                if('a' <= temp && temp <= 'f'){
                    newKey |= (1 << (temp - 'a')); // 열쇠 획득
                }

                if('A' <= temp && temp <= 'F'){
                    int need = 1 << (temp - 'A'); // 필요한 열쇠
                    if((current.key & need) == 0 ) continue; // 키 없으면 못간다잉
                }

                if(!visited[newX][newY][newKey]){
                    visited[newX][newY][newKey] = true;
                    queue.offer(new Position(newX, newY, newKey, current.dist + 1));
                }
            }
        }
        return -1;
    }

    public static class Position{
        int x;
        int y;
        int key;
        int dist;

        Position(int x, int y, int key, int dist){
            this.x = x;
            this.y = y;
            this.key = key;
            this.dist = dist;
        }
    }
}
