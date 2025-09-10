package Baekjoon.Simulation;

import java.util.*;
import java.io.*;

public class 이공사팔 {

    static int N, maxNumber;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        maxNumber = Integer.MIN_VALUE;
        int[][] map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, map);
        System.out.println(maxNumber);
    }

    public static void backTracking(int depth, int[][] map) {
        if(depth == 5) {
            // 1. 현재 맵에서 가장 큰 값 찾기
            int max = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    max = Math.max(max, map[i][j]);
                }
            }

            // 2. 전체 큰 값 갱신
            maxNumber = Math.max(maxNumber, max);
            return;
        }


        int[][] copy = copyMap(map);
        moveLeft(copy);
        backTracking(depth+1, copy);

        copy = copyMap(map);
        moveRight(copy);
        backTracking(depth+1, copy);

        copy = copyMap(map);
        moveUp(copy);
        backTracking(depth+1, copy);

        copy = copyMap(map);
        moveDown(copy);
        backTracking(depth+1, copy);

    }

    public static void moveLeft(int[][] map) {
        for(int i=0; i<N; i++) {
            // 해당 블록이 이미 합쳐졌는지 확인
            boolean[] isSum = new boolean[N];
            // 열 확인
            for(int j=0; j<N-1; j++) {
                if(map[i][j] == 0 ) continue; // 현재 블록이 0이면 다음 블록 잡기

                // 하나 잡고 그 뒤에 쭉 확인
                for(int k=j+1; k<N; k++) {
                    if(map[i][k] == 0) continue;
                    else if(map[i][k] == map[i][j] && !isSum[j]){
                        map[i][j] *= 2;
                        map[i][k] = 0;
                        isSum[j] = true;
                    }
                    break;
                }
            }

            // 한 줄 합치기 끝났으면 왼쪽으로 밀착시키기
            int[] newRow = new int[N];
            int index = 0;
            for(int j=0; j<N; j++){
                if(map[i][j] != 0){
                    newRow[index++] = map[i][j];
                }
            }
            map[i] = newRow;
        }
    }

    public static void moveRight(int[][] map) {
        for(int i=0; i<N; i++){
            //해당 블록이 이미 합쳐졌는지 확인
            boolean[] isSum = new boolean[N];

            //열 확인
            for(int j=N-1; j>0; j--){
                if(map[i][j] == 0) continue; // 현재 블록이 0이면 다음 블록 잡기

                // 하나 잡고 그 뒤에 쭉 확인
                for(int k=j-1; k>=0; k--){
                    if(map[i][k] == 0) continue;
                    else if(map[i][k] == map[i][j] && !isSum[j]){
                        map[i][j] *= 2;
                        map[i][k] = 0;
                        isSum[j] = true;
                    }
                    break;
                }
            }

            // 한 줄 끝났으면 오른쪽으로 밀기
            int[] newRow = new int[N];
            int index = N-1;
            for(int j=N-1; j>=0; j--){
                if(map[i][j] != 0){
                    newRow[index--] = map[i][j];
                }
            }

            map[i] = newRow;
        }
    }

    public static void moveUp(int[][] map) {
        for(int i=0; i<N; i++){
            boolean[] isSum = new boolean[N];

            for(int j=0; j<N-1; j++){
                if(map[j][i] == 0) continue;

                for(int k=j+1; k<N; k++){
                    if(map[k][i] == 0) continue;
                    else if(map[k][i] == map[j][i] && !isSum[j]){
                        map[j][i] *= 2;
                        map[k][i] = 0;
                        isSum[j] = true;
                    }
                    break;
                }
            }

            int[] newCol = new int[N];
            int index = 0;
            for(int j=0; j<N; j++){
                if(map[j][i] != 0) {
                    newCol[index++] = map[j][i];
                }
            }

            for(int j=0; j<N; j++){
                map[j][i] = newCol[j];
            }
        }
    }

    public static void moveDown(int[][] map) {
        for (int i = 0; i < N; i++) {
            boolean[] isSum = new boolean[N];

            for (int j = N - 1; j > 0; j--) {
                if (map[j][i] == 0) continue;

                for (int k = j - 1; k >= 0; k--) {
                    if (map[k][i] == 0) continue;
                    if (map[k][i] == map[j][i] && !isSum[j]) {
                        map[j][i] *= 2;
                        map[k][i] = 0;
                        isSum[j] = true;
                    }
                    break;
                }
            }

            int[] newCol = new int[N];
            int idx = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    newCol[idx--] = map[j][i];
                }
            }

            for (int j = 0; j < N; j++) {
                map[j][i] = newCol[j];
            }
        }
    }


    public static int[][] copyMap(int[][] map){
        int[][] copy = new int[N][N];

        for(int i=0; i<N; i++) {
            copy[i] = map[i].clone();
        }

        return copy;
    }

    public static void display(int[][] map){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}