package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10026 {

    static char[][] nomalMap;
    static char[][] anomalyMap;
    static boolean[][] visited;
    static int anomalyCount, nomalCount;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;

    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());

        nomalMap = new char[N][N];
        anomalyMap = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = bf.readLine();
            for(int j=0; j<N; j++){
                nomalMap[i][j] = str.charAt(j);
                if(str.charAt(j) == 'R'){
                    anomalyMap[i][j] = 'G';
                }else{
                    anomalyMap[i][j] = str.charAt(j);
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    if(nomalMap[i][j] == 'R' || nomalMap[i][j] == 'G' || nomalMap[i][j] == 'B'){
                        char c = nomalMap[i][j];
                        DFS(i,j,c, nomalMap);
                        nomalCount++;
                    }
                }
            }
        }

        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    if(anomalyMap[i][j] == 'G' || anomalyMap[i][j] == 'B'){
                        char c = anomalyMap[i][j];
                        DFS(i,j,c, anomalyMap);
                        anomalyCount++;
                    }
                }
            }
        }

        System.out.print(nomalCount + " " + anomalyCount);
    }

    private static void DFS(int x, int y, char c, char[][] map){
        if(!visited[x][y]){
            visited[x][y] = true;
        }

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < N && newY <N){
                if(map[newX][newY] == c && !visited[newX][newY]){
                    DFS(newX, newY, c, map);
                }
            }
        }
    }
}
