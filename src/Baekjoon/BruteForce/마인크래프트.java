package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHiegh = 0;

        // 최소 높이부터 최대 높이까지 다 해봄
        for(int i=min; i<=max; i++){
            int time = 0;
            int block = B;

            // (0,0)부터 (N,M)까지
            for(int x=0; x<N; x++){
                for(int y=0; y<M; y++){
                    // 현재 위치가 바꿀 높이보다 크다면
                    // 블록을 제거하여 인벤토리에 넣는다.
                    // 시간은 블록 개수 * 2
                    if(i < map[x][y]){
                        time += (map[x][y] - i) * 2;
                        block += map[x][y] - i;
                    }
                    // 현재 위치가 바꿀 높이보다 작다면
                    // 인벤토리에서 블록을 하나 꺼내 블록 위에 놓는다.
                    // 시간은 블록 개수 * 1
                    else{
                        time += i - map[x][y];
                        block -= i - map[x][y];
                    }
                }
            }

            // 메꿨는데 블록 개수가 0이면 안됨
            if(block < 0) break;

            // 답이 여러개면 그 중에서 땅의 높이가 가장 큰 것 저장
            if(resultTime >= time){
                resultTime = time;
                resultHiegh = i;
            }
        }

        System.out.print(resultTime + " " + resultHiegh);
    }
}
