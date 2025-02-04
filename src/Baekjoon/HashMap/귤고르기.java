package Baekjoon.HashMap;

import java.util.*;

public class 귤고르기 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        solution(k, tangerine);
    }

    private static void solution(int k, int[] tangerine){
        Map<Integer, Integer> countMap = new HashMap<>();

        //귤 크기별 개수 세기
        for(int size : tangerine){
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        //귤 개수를 내림차순으로 정렬
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());

        //가장 많은 귤부터 선택해 k개 이상이 될 때까지 종류 세기
        //이 문제의 핵심은 귤 크기가 아닌 개수가 핵심이다.
        int sum = 0, kind = 0;
        for(int count : counts){
            sum += count;
            kind++;

            if(sum >= k) break;
        }

        System.out.println(kind);
    }
}
