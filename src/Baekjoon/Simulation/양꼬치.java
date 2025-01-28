package Baekjoon.Simulation;

public class 양꼬치 {
    public static void main(String[] args) {
        int n = 10;
        int k = 3;

        solution(n, k);
    }

    private static void solution(int n, int k){
        int service = n / 10;

        System.out.println((n*12000) + (k*2000) - (service*2000));
    }
}
