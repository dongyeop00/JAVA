package Baekjoon.Simulation;

public class 삼진법뒤집기 {
    public static void main(String[] args) {
        int n = 45;
        solution(n);
    }

    private static void solution(int n){
        String str = "";

        while(n>0){
            str += n % 3;
            n /= 3;
        }

        // 문자열 str을 3진수로 해석하여 10진수로 변환
        System.out.println(Integer.parseInt(str,3));
    }
}
