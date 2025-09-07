package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과먹기 {

    static int N, maxApple, answer;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            maxApple = 0;
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxApple = Math.max(maxApple, map[i][j]);
                }
            }

            solving(0, 0, 0, 0, 1);
            System.out.println("#" + testCase + " " + answer);
        }
    }

    /**
     *
     * @param x : 현재 x 위치
     * @param y : 현재 y 위치
     * @param dir : 현재 방향
     * @param count : 꺽은 횟수
     * @param apple : 타겟 사과 번호
     */
    private static void solving(int x, int y, int dir, int count, int apple){
        // basis part
        if(apple-1 == maxApple){
            answer = Math.min(answer, count);
            return;
        }

        // 현재 자리에 사과가 있다면
        if(map[x][y] == apple){
            apple += 1;
        }

        // inductive part
        // 회전하는 경우 (회전에서 사과가 있다면 or 지도 밖으로 나가면)
        int newX = x + dx[dir];
        int newY = y + dy[dir];

        // 회전했을 때 사과가 있으면 || 한 칸 전진했을 때 좌표 밖이라면 => 회전하기
        if(check(x, y, dir, apple) || (newX < 0 || newY < 0 || newX >= N || newY >= N)){
            int newDir = (dir + 1) % 4; // 오른쪽으로 회전
            solving(x, y, newDir, count+1, apple);
            return;
        }

        // 직진하는 경우
        solving(newX, newY, dir, count, apple);
    }

    private static boolean check(int x, int y, int dir, int apple){
        int newDir = (dir + 1) % 4;
        while(x >= 0 && y >= 0 && x < N && y < N){
            x += dx[newDir];
            y += dy[newDir];

            // 회전하고 앞으로 쭉 가는데 사과가 있다면 true
            if(x >= 0 && y >= 0 && x < N && y < N){
                if(map[x][y] == apple) return true;
            }
        }

        // 회전하고 앞으로 쭉 가는데 사과가 없다면 false
        return false;
    }
}
