package Baekjoon.BruteForce;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {
                {60,50},
                {30,70},
                {60,30},
                {80,40}
        };
        solution(sizes);
    }

    private static void solution(int[][] sizes){
        int a = 0;
        int b = 0;

        for(int i=0; i<sizes.length; i++){
            int A = Math.max(sizes[i][0], sizes[i][1]);
            int B = Math.min(sizes[i][0], sizes[i][1]);
            a = Math.max(a, A);
            b = Math.max(b, B);
        }

        System.out.println(a*b);
    }
}
