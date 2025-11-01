package Baekjoon.달리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 낚시왕 {

    static int N, M, S, result;
    static List<Shark> sharks;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        result = 0;

        sharks = new ArrayList<>();
        for(int i=0; i<S; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            sharks.add(new Shark(x, y, s, d, z));
        }

        // 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
        for(int fishman = 0; fishman < M; fishman++){

            // 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다.
            // 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
            int index = -1;
            int minX = Integer.MAX_VALUE;

                // 2.1 땅과 가장 가까운 상어를 찾음
            for(int i=0; i<sharks.size(); i++){
                Shark s = sharks.get(i);
                if(s.y == fishman && s.x < minX){
                    minX = s.x;
                    index = i;
                }
            }
                // 2.2 상어 제거
            if(index != -1){
                result += sharks.get(index).z;
                sharks.remove(index);
            }

            // 3. 상어가 이동한다.
            Shark[][] board = new Shark[N][M];
            for(Shark current : sharks){

                for(int i=0; i<current.s; i++){
                    int newX = current.x + dx[current.d];
                    int newY = current.y + dy[current.d];

                    // 경계 벗어나면 방향만 바꾸고 재시작
                    if(newX < 0 || newY < 0 || newX >= N || newY >= M){
                        if(current.d == 0) current.d = 1;
                        else if(current.d == 1) current.d = 0;
                        else if(current.d == 2) current.d = 3;
                        else  current.d = 2;

                        newX = current.x + dx[current.d];
                        newY = current.y + dy[current.d];
                    }

                    current.x = newX;
                    current.y = newY;
                }

                // 상어 다시 배치하기
                if(board[current.x][current.y] == null || board[current.x][current.y].z < current.z){
                    board[current.x][current.y] = new Shark(current.x, current.y, current.s, current.d, current.z);
                }
            }

            sharks.clear();
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(board[i][j] != null){
                        sharks.add(board[i][j]);
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static class Shark{
        int x;
        int y;
        int s;
        int d;
        int z;

        public Shark(int x, int y, int s, int d, int z) {
            this.x = x; // 좌표 r
            this.y = y; // 좌표 c
            this.s = s; // 속력
            this.d = d; // 이동 방향
            this.z = z; // 크기
        }
    }
}
