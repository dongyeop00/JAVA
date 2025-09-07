package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기 {

    static final int N = 10;
    static int[][] map;
    static int[] paper;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[N][N];
        paper = new int[]{0, 5, 5, 5, 5, 5};
        answer = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void backTracking(int count){
        int sx = -1, sy = -1;

        L:for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(map[x][y] == 1){
                    sx = x;
                    sy = y;
                    break L;
                }
            }
        }

        // basis part
        if(sx == -1 && sy == -1){
            answer = Math.min(answer, count);
            return;
        }

        // inductive part
        // 색종이 최대 사이즈 구하기
        int size = getSize(sx, sy);

        // 최대 사이즈부터 붙여 나간다.
        while(size>=0){
            if(paper[size] > 0){ // size의 종이가 남아 있다면

                //색종이 붙이기
                paper[size]--;
                for(int i=sx; i<sx+size; i++){
                    for(int j=sy; j<sy+size; j++){
                        map[i][j] = 0;
                    }
                }

                backTracking(count+1);

                //색종이 되돌리기
                paper[size]++;
                for(int i=sx; i<sx+size; i++){
                    for(int j=sy; j<sy+size; j++){
                        map[i][j] = 1;
                    }
                }
            }
            // 색종이 사이즈 하나 줄이기
            size--;
        }
    }

    public static int getSize(int sx, int sy){
        int size = 5;
        while(size>0){
            boolean ok = true;
            L:for(int x=sx; x<sx+size; x++){
                for(int y=sy; y<sy+size; y++){
                    // 다음 좌표가 범위 밖이거나, 덮는 부분이 0이라면
                    if(x < 0 || y < 0 || x >= N || y >= N || map[x][y] == 0){
                        ok = false;
                        break L;
                    }
                }
            }
            if(ok) return size;
            size--;
        }
        return 0;
    }
}
