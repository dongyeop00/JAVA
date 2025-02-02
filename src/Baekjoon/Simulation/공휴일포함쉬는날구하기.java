package Baekjoon.Simulation;

import java.util.HashSet;
import java.util.Set;

public class 공휴일포함쉬는날구하기 {
    public static void main(String[] args) {
        int x = 7;
        int[][] H = {
                {1, 1}, {1, 21}, {1, 22}, {1, 23}, {3, 1}, {5, 5}, {5, 27},
                {6, 6}, {8, 15}, {9, 28}, {9, 29}, {9, 30}, {10, 3}, {10, 9}, {12, 25}
        };
        solution(x, H);
    }

    private static void solution(int x, int[][] H) {
        int[] dayofMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Set<Integer> offDaySet = new HashSet<>();
        int currentDayOfWeek = x; // 1월 1일의 요일 (x값)

        int totalDaysPassed = 0;

        // 1년 동안 모든 날짜를 순회
        for (int i = 0; i < 12; i++) {
            for (int j = 1; j <= dayofMonth[i]; j++) {
                // 토요일(6) 또는 일요일(7)인 경우 휴일 추가
                if (currentDayOfWeek == 6 || currentDayOfWeek == 7) {
                    offDaySet.add(totalDaysPassed);
                }
                totalDaysPassed++;
                currentDayOfWeek = (currentDayOfWeek % 7) + 1;
            }
        }

        // 공휴일 추가
        for (int[] num : H) {
            int month = num[0] - 1;
            int day = num[1] - 1;
            int holidayIndex = day;

            for (int i = 0; i < month; i++) {
                holidayIndex += dayofMonth[i];
            }

            offDaySet.add(holidayIndex);
        }

        System.out.println(offDaySet.size());
    }
}
