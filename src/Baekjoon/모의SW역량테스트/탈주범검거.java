package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {

    static int N, M, R, C, L;
    static int[][] map;
    //상하좌우
    static int[] type1dx = {-1, 0, 1, 0};
    static int[] type1dy = {0, 1, 0, -1};
    //상하
    static int[] type2dx = {-1, 1};
    static int[] type2dy = {0, 0};
    //좌우
    static int[] type3dx = {0 ,0};
    static int[] type3dy = {-1, 1};
    //상우
    static int[] type4dx = {-1, 0};
    static int[] type4dy = {0, 1};
    //하우
    static int[] type5dx = {1, 0};
    static int[] type5dy = {0, 1};
    //하좌
    static int[] type6dx = {1, 0};
    static int[] type6dy = {0, -1};
    //상좌
    static int[] type7dx = {-1, 0};
    static int[] type7dy = {0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = BFS(R,C);
            System.out.println("#" + testCase + " " + result);
        }
    }

    public static int BFS(int x, int y){
        if(map[x][y] == 0) return 0;

        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int time = 1;
        int count = 1;

        queue.offer(new Position(x, y, map[x][y]));
        visited[x][y] = true;

        while(!queue.isEmpty() && time < L) {
            int size = queue.size();
            for (int cnt = 0; cnt < size; cnt++) {
                Position current = queue.poll();
                int type = current.type;

                switch (type) {
                    case 1:
                        for (int i = 0; i < 4; i++) {
                            int newX = current.x + type1dx[i];
                            int newY = current.y + type1dy[i];
                            int d = i;
                            if (check(newX, newY) && !visited[newX][newY] && map[newX][newY] != 0 && isConnect(d, map[newX][newY])) {
                                visited[newX][newY] = true;
                                queue.offer(new Position(newX, newY, map[newX][newY]));
                                count++;
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < 2; i++) {
                            int newX = current.x + type2dx[i];
                            int newY = current.y + type2dy[i];
                            int d = dirIndex(type2dx[i], type2dy[i]);
                            if (check(newX, newY) && !visited[newX][newY] && map[newX][newY] != 0 && isConnect(d, map[newX][newY])){
                                visited[newX][newY] = true;
                                queue.offer(new Position(newX, newY, map[newX][newY]));
                                count++;
                            }
                        }
                        break;
                    case 3:
                        for (int i = 0; i < 2; i++) {
                            int newX = current.x + type3dx[i];
                            int newY = current.y + type3dy[i];
                            int d = dirIndex(type3dx[i], type3dy[i]);
                            if (check(newX, newY) && !visited[newX][newY] && map[newX][newY] != 0 && isConnect(d, map[newX][newY])){
                                visited[newX][newY] = true;
                                queue.offer(new Position(newX, newY, map[newX][newY]));
                                count++;
                            }
                        }
                        break;
                    case 4:
                        for (int i = 0; i < 2; i++) {
                            int newX = current.x + type4dx[i];
                            int newY = current.y + type4dy[i];
                            int d = dirIndex(type4dx[i], type4dy[i]);
                            if (check(newX, newY) && !visited[newX][newY] && map[newX][newY] != 0 && isConnect(d, map[newX][newY])){
                                visited[newX][newY] = true;
                                queue.offer(new Position(newX, newY, map[newX][newY]));
                                count++;
                            }
                        }
                        break;
                    case 5:
                        for (int i = 0; i < 2; i++) {
                            int newX = current.x + type5dx[i];
                            int newY = current.y + type5dy[i];
                            int d = dirIndex(type5dx[i], type5dy[i]);
                            if (check(newX, newY) && !visited[newX][newY] && map[newX][newY] != 0 && isConnect(d, map[newX][newY])){
                                visited[newX][newY] = true;
                                queue.offer(new Position(newX, newY, map[newX][newY]));
                                count++;
                            }
                        }
                        break;
                    case 6:
                        for (int i = 0; i < 2; i++) {
                            int newX = current.x + type6dx[i];
                            int newY = current.y + type6dy[i];
                            int d = dirIndex(type6dx[i], type6dy[i]);
                            if (check(newX, newY) && !visited[newX][newY] && map[newX][newY] != 0 && isConnect(d, map[newX][newY])){
                                visited[newX][newY] = true;
                                queue.offer(new Position(newX, newY, map[newX][newY]));
                                count++;
                            }
                        }
                        break;
                    case 7:
                        for (int i = 0; i < 2; i++) {
                            int newX = current.x + type7dx[i];
                            int newY = current.y + type7dy[i];
                            int d = dirIndex(type7dx[i], type7dy[i]);
                            if (check(newX, newY) && !visited[newX][newY] && map[newX][newY] != 0 && isConnect(d, map[newX][newY])){
                                visited[newX][newY] = true;
                                queue.offer(new Position(newX, newY, map[newX][newY]));
                                count++;
                            }
                        }
                        break;
                }
            }
            time++;
        }

        return count;
    }

    public static int dirIndex(int x, int y){
        if(x == -1 && y == 0) return 0; // 상
        if(x ==  0 && y == 1) return 1; // 우
        if(x ==  1 && y == 0) return 2; // 하
        if(x ==  0 && y == -1) return 3; // 좌
        return -1;
    }

    public static boolean isConnect(int d, int nextType){
        int need = opposite(d);
        switch(nextType){
            case 1: return true;                       // 상하좌우
            case 2: return need == 0 || need == 2;     // 상하
            case 3: return need == 1 || need == 3;     // 좌우
            case 4: return need == 0 || need == 1;     // 상우
            case 5: return need == 1 || need == 2;     // 하우
            case 6: return need == 2 || need == 3;     // 하좌
            case 7: return need == 0 || need == 3;     // 상좌
            default: return false;
        }
    }

    public static int opposite(int d){
        return (d+2) % 4;
    }

    public static boolean check(int x, int y){
        if(x >= 0 && y >= 0 && x < N && y < M) return true;
        return false;
    }

    public static class Position{
        int x;
        int y;
        int type;

        Position(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
