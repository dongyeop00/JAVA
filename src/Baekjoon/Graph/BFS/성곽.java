package Baekjoon.Graph.BFS;

import java.io.*;
import java.util.*;

/*
    2진수
    1 : 0001
    2 : 0010
    3 : 0011
    4 : 0100
    5 : 0101
    6 : 0110
    7 : 0111
    8 : 1000
    9 : 1001
    10: 1010
    11: 1011
    12: 1100
    13: 1101
    14: 1110
    15: 1111
 */

public class 성곽 {

    static int N, M;
    static int[][] wall;
    static int[][] roomId;
    static boolean[][] visited;
    static List<Integer> roomSize = new ArrayList<>();
    // 서(0), 북(1), 동(2), 남(3)
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        wall = new int[N][M];
        roomId = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                wall[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 1. 방마다 라벨링 하기
        int roomcount = 0;
        int maxRoomSize = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    int size = BFS(i, j, roomcount);
                    roomSize.add(size);
                    maxRoomSize = Math.max(maxRoomSize, size);
                    roomcount++;
                }
            }
        }

        // 2. 벽 하나 제거했을 때 최대 방 크기
        // - 모든 칸 (X, Y)에 대해 네 방향을 확인
        // - 현재 칸과 인접 칸이 다른 방향이고, 그 사이에 벽이 존재한다면 두 방의 크기를 합침
        // - 합치면서 최대값을 갱신
        int maxAfterBreak = maxRoomSize;
        for(int x=0; x<N; x++){
            for(int y=0; y<M; y++){
                int currentID = roomId[x][y];

                // 서 북 동 남 순서로 확인
                for(int d=0; d<4; d++){
                    int newX  = x + dx[d];
                    int newY =  y + dy[d];

                    if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                    int nextID = roomId[newX][newY];

                    // 현재 방이랑 다음 방이랑 같은 방이 아니고
                    if(currentID != nextID){
                        // 그 사이에 벽이 존재한다면
                        if((wall[x][y] & (1<<d)) != 0){
                            maxAfterBreak = Math.max(maxAfterBreak, roomSize.get(currentID) + roomSize.get(nextID));
                        }
                    }
                }
            }
        }

        System.out.println(roomcount);
        System.out.println(maxRoomSize);
        System.out.println(maxAfterBreak);
    }

    public static int BFS(int sx, int sy, int id){
        Queue<Position> queue = new LinkedList<>();
        int count = 1;

        queue.offer(new Position(sx, sy));
        visited[sx][sy] = true;
        roomId[sx][sy] = id;

        while(!queue.isEmpty()){
            Position current = queue.poll();

            for(int i=0; i<4; i++){

                if((wall[current.x][current.y] & (1 << i)) == 0) {
                    int newX = current.x + dx[i];
                    int newY = current.y + dy[i];

                    if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                    if (visited[newX][newY]) continue;

                    queue.offer(new Position(newX, newY));
                    visited[newX][newY] = true;
                    roomId[newX][newY] = id;
                    count++;
                }
            }
        }

        return count;
    }

    public static class Position{
        int x;
        int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
