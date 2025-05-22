package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1189 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count;
    static int R, C, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];
        count = 0;

        for(int i=0; i<R; i++){
            String str = bufferedReader.readLine();
            for(int j=0; j<C; j++){
                char temp = str.charAt(j);
                if(temp == '.'){
                    map[i][j] = 0;
                }else{
                    map[i][j] = 1;
                }
            }
        }

        backTracking(R-1,0, 1);
        System.out.println(count);
    }

    private static void backTracking(int x, int y, int depth){

        visited[x][y] = true;

        if(x==0 && y==C-1){
            if(depth==K){
                count++;
            }
            visited[x][y] = false;
            return;
        }

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < R && newY < C){
                if(map[newX][newY] == 0 && !visited[newX][newY]){
                    backTracking(newX, newY, depth+1);
                }
            }
        }

        visited[x][y] = false;
    }
}
