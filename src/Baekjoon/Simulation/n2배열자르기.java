package Baekjoon.Simulation;

import java.util.ArrayList;
import java.util.List;

public class n2배열자르기 {
    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;

        solution(n, left, right);
    }

    private static void solution(int n, long left, long right){
        List<Long> list = new ArrayList<>();

        for(long i=left; i<=right; i++){
            list.add(Math.max(i/n, i%n) + 1);
        }

        System.out.println(list);
    }
}
