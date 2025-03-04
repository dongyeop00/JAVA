package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 영역구하기_백준 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] map;
    static int m,n,k, count;
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<k; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            mapSet(x1, y1, x2, y2);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    count = 1;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

    }

    private static void dfs(int x, int y){
        if(!visited[x][y]){
            visited[x][y] = true;
        }

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < m  && newY < n){
                if(map[newX][newY] == 0 && !visited[newX][newY]){
                    dfs(newX, newY);
                    count++;
                }
            }
        }
    }

    private static void mapSet(int x1, int y1, int x2, int y2){
        for(int i = y1; i<y2; i++){
            for(int j = x1; j<x2; j++){
                map[i][j] = 1;
            }
        }
    }
}
