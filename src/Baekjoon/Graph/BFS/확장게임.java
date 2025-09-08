package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 확장게임 {

    static int N, M, P;
    static int[] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        dist = new int[P+1];
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<P+1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Position>[] queue = new ArrayDeque[P+1];
        for(int i=0; i<P+1; i++){
            queue[i] = new ArrayDeque<>();
        }

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                char temp = str.charAt(j);

                if(temp == '.') map[i][j] = 0;
                else if(temp == '#') map[i][j] = -1;
                else{
                    int num = temp - '0';
                    map[i][j] = num;
                    queue[num].offer(new Position(i,j));
                }
            }
        }

        // 계속 반복
        while(true){
            boolean allEmpty = true;

            // 사람들 수 만큼 반복
            for(int player=1; player<P+1; player++){
                int maxLevel = dist[player]; //사람마다 탐색할 수 있는 최대 레벨

                // 레벨 0부터 탐색
                for(int level=0; level<maxLevel; level++){
                    int size = queue[player].size(); //현재 플레이어의 큐 사이즈를 가져옴
                    if(size == 0) break;

                    for(int start=0; start<size; start++){
                        Position current = queue[player].poll();

                        for(int dir=0; dir<4; dir++){
                            int newX = current.x + dx[dir];
                            int newY = current.y + dy[dir];

                            if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                            if(map[newX][newY] != 0 ) continue;

                            map[newX][newY] = player;
                            queue[player].offer(new Position(newX, newY));
                        }
                    }
                }

                // 해당 플레이어가 이제 확장하지 못한다면
                if(!queue[player].isEmpty()) allEmpty = false;
            }

            // 모든 플레이어 큐가 비면 종류
            if(allEmpty) break;
        }

        // 개수 세기
        int[] count = new int[P+1];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int temp = map[i][j];
                if(temp > 0){
                    count[temp]++;
                }
            }
        }

        for(int i=1; i<P+1; i++){
            System.out.print(count[i] + " ");
        }
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
