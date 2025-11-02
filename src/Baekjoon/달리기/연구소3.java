package Baekjoon.달리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소3 {

    static int N, M, minTime;
    static int[][] map;
    static List<Virus> virusList = new ArrayList<>();
    static Virus[] virusSelect;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virusSelect = new Virus[M];
        minTime = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virusList.add(new Virus(i, j));
            }
        }

        solve(0, 0);
        System.out.println(minTime == Integer.MIN_VALUE ? -1 : minTime);
    }

    public static void solve(int depth, int index){
        if(depth == M){
            minTime = Math.min(minTime, BFS(virusSelect));
            return;
        }

        for(int i=index; i<virusList.size(); i++){
            virusSelect[depth] = virusList.get(i);
            solve(depth+1, i+1);
        }
    }

    public static int BFS(Virus[] virusSelect){
        Queue<Virus> queue = new LinkedList<>();
        int[][] time = new int[N][N];

        for(int i=0; i<N; i++){
            Arrays.fill(time[i], INF);
        }

        for(Virus v : virusSelect){
            queue.offer(new Virus(v.x, v.y, 0));
            time[v.x][v.y] = 0;
        }

        while(!queue.isEmpty()){
            Virus current = queue.poll();

            if(time[current.x][current.y] < current.time) continue;

            for(int i=0; i<4; i++){
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
                if(map[newX][newY] == 1) continue;

                if(time[newX][newY] > time[current.x][current.y] + 1){
                    time[newX][newY] = time[current.x][current.y] + 1;
                    queue.offer(new Virus(newX, newY, time[newX][newY]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(time[i][j] == INF) continue;
                max = Math.max(max, time[i][j]);
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static class Virus{
        int x;
        int y;
        int time;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
