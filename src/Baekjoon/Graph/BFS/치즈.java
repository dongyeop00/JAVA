package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치즈 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int second = 0;

        while (true) {
            // visited 초기화
            visited = new boolean[N][M];

            // 바깥 공기 탐색
            DFS(0, 0);

            // 바깥 치즈 획득
            List<Position> list = getCheese();

            if(list.size() == 0) break;

            second = list.size();

            // 바깥 치즈 녹이기
            meltCheese(list);

            time++;
        }


        System.out.println(time);
        System.out.println(second);
    }

    // 바깥 공기 탐색
    public static void DFS(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
            if(visited[newX][newY]) continue;
            if(map[newX][newY] != 0) continue;

            visited[newX][newY] = true;
            DFS(newX, newY);
        }
    }

    public static List<Position> getCheese(){
        List<Position> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    for(int d=0; d<4; d++){
                        int newX = i + dx[d];
                        int newY = j + dy[d];

                        if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                        if(!visited[newX][newY]) continue;
                        list.add(new Position(i, j));
                        break;
                    }
                }
            }
        }

        return list;
    }

    public static void meltCheese(List<Position> list){
        for(Position p : list){
            map[p.x][p.y] = 0;
            visited[p.x][p.y] = true;
        }
    }

    public static class Position{
        int x, y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
