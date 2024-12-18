package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek14502 {

    static int[][] map;
    static int[][] copymap;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int countMax = Integer.MIN_VALUE;
    static int N, M, count;

    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        DFS(0);
        System.out.println(countMax);
    }

    private static void DFS(int depth){
        if(depth == 3){
            BFS();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    DFS(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void BFS(){
        Queue<Virus> queue = new LinkedList<>();
        copymap = new int[N][M];

        for(int i=0; i<N; i++){
            copymap[i] = map[i].clone();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copymap[i][j] == 2){
                    queue.offer(new Virus(i,j));
                }
            }
        }

        while(!queue.isEmpty()){
            Virus virus = queue.poll();

            int currentX = virus.x;
            int currentY = virus.y;

            for(int i=0; i<4; i++){
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                if(newX >= 0 && newY >= 0 && newX < N && newY < M){
                    if(copymap[newX][newY] == 0){
                        copymap[newX][newY] = 2;
                        queue.offer(new Virus(newX, newY));
                    }
                }
            }
        }

        countSafeZone(copymap);
    }

    private static void countSafeZone(int[][] copy){
        count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copy[i][j] == 0){
                    count++;
                }
            }
        }
        countMax = Math.max(countMax, count);
    }

    private static class Virus{
        int x;
        int y;
        Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
