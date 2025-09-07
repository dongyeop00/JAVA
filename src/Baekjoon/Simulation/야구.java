package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 야구 {

    static int N;
    static int[][] inning; // 해당 이닝에서 해당 선수의 결과
    static int[] order = new int[9]; // 타순
    static boolean[] used = new boolean[10];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        inning = new int[N][10];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<10; j++){
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1번 선수는 4번 타순에 고정
        order[3] = 1;
        used[1] = true;

        // 나머지 2~9번을 모든 위치에 배치
        permutation(0);

        System.out.println(result);
    }

    public static void permutation(int index){
        if(index == 9){
            result = Math.max(result, simulation(order));
            return;
        }

        // 4번 타순은 1번 고정
        if(index == 3){
            permutation(index+1);
            return;
        }

        for(int i=2; i<10; i++){
            if(!used[i]){
                used[i] = true;
                order[index] = i;
                permutation(index+1);
                used[i] = false;
            }
        }
    }

    private static int simulation(int[] order) {
        int score = 0;
        int playerIndex = 0;

        // 게임 시작
        for(int game=0; game<N; game++){
            int out = 0;
            int base = 0; // 3비트 (2번비트[3루], 1번비트[2루], 0번비트[1루])

            while (out < 3) {
                int player = order[playerIndex];
                int playerResult = inning[game][player]; // 0~4

                if (playerResult == 0) {
                    // 아웃
                    out++;
                } else if (playerResult == 4) {
                    // 홈런
                    score += Integer.bitCount(base) + 1;
                    base = 0;
                } else {
                    // 1,2,3루타
                    int moved = base << playerResult;         // 기존 주자 이동
                    score += Integer.bitCount(moved >> 3);    // 홈 넘어간 주자 수 득점
                    base = moved & 0b111;                     // 3루까지만 유지
                    base |= (1 << (playerResult - 1));        // 타자 r루 배치
                }

                playerIndex++;
                if (playerIndex == 9) playerIndex = 0;
            }
        }

        return score;
    }
}
