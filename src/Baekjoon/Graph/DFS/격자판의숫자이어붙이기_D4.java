package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 격자판의숫자이어붙이기_D4 {

    static int[][] map;
    static Set<String> hash;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            map = new int[4][4];
            hash = new HashSet<>();

            for(int i=0; i<4; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=0; j<4; j++){
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    DFS(i,j,0,"" + map[i][j]);
                }
            }

            System.out.println("#" + test_case + " " + hash.size());
        }
    }

    public static void DFS(int x, int y, int depth, String number){
        if(depth == 6){
            hash.add(number);
            return;
        }

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < 4 && newY < 4){
                DFS(newX, newY, depth+1, number + map[newX][newY]);
            }
        }
    }
}
