package Baekjoon.Simulation;

import java.util.*;
import java.io.*;

public class 붐버맨2 {

    static int R, C, N;
    static int[][] beforeMap;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        beforeMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == 'O') {
                    beforeMap[i][j] = 1; // 폭탄
                } else {
                    beforeMap[i][j] = 0; // 빈 칸
                }
            }
        }

        if (N == 1) {
            display(beforeMap);
        } else if (N % 2 == 0) {
            displayFullBoom();
        } else if (N % 4 == 3) {
            int[][] afterFirstBoom = simulateBoom(beforeMap);
            display(afterFirstBoom);
        } else if (N % 4 == 1) {
            int[][] afterFirstBoom = simulateBoom(beforeMap);
            int[][] afterSecondBoom = simulateBoom(afterFirstBoom);
            display(afterSecondBoom);
        }
    }

    // 모든 칸 폭탄
    public static void displayFullBoom() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print("O");
            }
            System.out.println();
        }
    }

    // 맵 출력
    public static void display(int[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] == 1 ? "O" : ".");
            }
            System.out.println();
        }
    }

    // 폭탄 터지는 시뮬레이션
    public static int[][] simulateBoom(int[][] map) {
        int[][] next = new int[R][C];

        // 일단 모든 칸에 폭탄 설치
        for (int i = 0; i < R; i++) {
            Arrays.fill(next[i], 1);
        }

        // 기존 폭탄이 터지면서 인접 칸 제거
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) {
                    next[i][j] = 0;
                    for (int d = 0; d < 4; d++) {
                        int newX = i + dx[d];
                        int newY = j + dy[d];
                        if (newX >= 0 && newY >= 0 && newX < R && newY < C) {
                            next[newX][newY] = 0;
                        }
                    }
                }
            }
        }

        return next;
    }
}

