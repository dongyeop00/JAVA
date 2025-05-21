package Baekjoon.BackTracking;

import java.util.Scanner;

public class Baek10974 {

    static int[] map;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        map = new int[N];
        visited = new boolean[N];

        backTracking(0);
    }

    private static void backTracking(int depth){
        if(depth == N){
            for(int num : map){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                map[depth] = i+1;
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
