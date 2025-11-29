package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집 {

    static char[][] map;
    static int R, C;
    static int count;
    static boolean checked;
    // 무조건 위로 붙어서 가야 최대의 공간이 나오므로 ↗ → ↘ 순서대로 탐색
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<R; i++){
            checked = false;
            map[i][0] = '-';
            DFS(i,0);
        }

        System.out.println(count);
    }

    public static void DFS(int x, int y){
        if(y == C-1){
            checked = true;
            count++;
            return;
        }

        for(int i=0; i<3; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX >= R || newY >= C) continue;
            if(map[newX][newY] == 'x') continue;
            if(map[newX][newY] == '-') continue;
            if(checked) continue;

            map[newX][newY] = '-';
            DFS(newX, newY);
        }
    }

    public static void display(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==============");
    }
}
