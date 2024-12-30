package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1987 {

    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count, maxcount = 0;
    static int R, C;
    static char start;
    static int[] alphabet;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        map = new char[R][C];
        alphabet = new int[26];

        for(int i=0; i<R; i++){
            String str = bufferedReader.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        alphabet[map[0][0] - 'A'] = 1;
        DFS(0,0, 1);
        System.out.println(maxcount);
    }

    private static void DFS(int x, int y, int count){
        maxcount = Math.max(maxcount, count);

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < R && newY < C){
                char newStart = map[newX][newY];
                if(alphabet[newStart - 'A'] == 0){
                    alphabet[newStart - 'A'] = 1;
                    DFS(newX, newY, count+1);
                    alphabet[newStart - 'A'] = 0;
                }
            }
        }
    }
}
