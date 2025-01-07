package Baekjoon.BackTracking;

import java.util.Scanner;

public class Baek9663 {

    static int[] map;
    static boolean[] visited;
    static int N, count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        map = new int[N];
        visited = new boolean[N];

        backTracking(0);
        System.out.println(count);
    }

    private static void backTracking(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            map[depth] = i;

            if(checkPossible(depth)){
                backTracking(depth+1);
            }
        }
    }

    private static boolean checkPossible(int col){

        for(int i=0; i<col; i++){
            //같은 행에 있을 경우
            if(map[i] == map[col]){
                return false;
            }
            //대각선에 위치할 경우
            else if(Math.abs(col-i) == Math.abs(map[col] - map[i])){
                return false;
            }
        }

        return true;
    }
}
