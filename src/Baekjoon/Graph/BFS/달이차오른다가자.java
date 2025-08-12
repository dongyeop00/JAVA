package Baekjoon.Graph.BFS;

import java.util.*;
import java.io.*;

public class 달이차오른다가자 {

    static int N, M, count;
    static char[][] map;
    static boolean[][][] visited;
    static Position start;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][64];
        count = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                char temp = str.charAt(j);

                if(temp == '0') {
                    start = new Position(i, j);
                }

                map[i][j] = temp;
            }
        }

        BFS(start.x, start.y);
        System.out.println(count == Integer.MAX_VALUE ? -1 : count);
    }

    public static void BFS(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y, 0, 0));
        visited[x][y][0] = true;

        while(!queue.isEmpty()) {
            Position current = queue.poll();

            for(int i=0; i<4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                int newDis = current.dist + 1;
                int newKey = current.keyMask;

                // 1) 경계
                if(newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    char cell = map[newX][newY];

                    //  2) 벽이 아니어야 함
                    if(cell != '#'){
                        boolean pass = true;

                        // 3) 문(A~F)면 키 보유 확인
                        if('A' <= cell && cell <= 'F'){
                            int need = 1 << (cell - 'A');
                            if((newKey & need) == 0 ){
                                pass = false;
                            }
                        }

                        // 4) 통과 가능이면 키 획득 반영
                        if(pass){
                            if('a' <= cell && cell <= 'f'){
                                newKey = newKey | (1 << (cell - 'a'));
                            }

                            // 5) 방문체크
                            if(!visited[newX][newY][newKey]){
                                visited[newX][newY][newKey] = true;

                                if(cell == '1'){
                                    count = Math.min(count, newDis);
                                }else{
                                    queue.offer(new Position(newX, newY, newDis, newKey));
                                }
                            }
                        }
                    }

                }

            }
        }
    }

    static class Position{
        int x;
        int y;
        int dist;
        int keyMask;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        Position(int x, int y, int dist, int keyMask){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.keyMask = keyMask;
        }
    }

}