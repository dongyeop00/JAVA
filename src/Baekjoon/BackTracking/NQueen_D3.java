package Baekjoon.BackTracking;

import java.util.Scanner;

public class NQueen_D3 {
    static int[] map;
    static int N, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++){
            N = sc.nextInt();

            map = new int[N];
            count = 0;

            backTracking(0);
            System.out.println("#" + test_case + " " + count);
        }
    }

    private static void backTracking(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            map[depth] = i;

            if(check(depth)){
                backTracking(depth+1);
            }
        }
    }

    private static boolean check(int col){
        for(int i=0; i<col; i++){
            if(map[col] == map[i]){ // 같은 열에 있을 때
                return false;
            } else if(Math.abs(col-i) == Math.abs(map[col] - map[i])){ // 같은 대각선에 있을 때
                return false;
            }
        }

        return true;
    }
}
