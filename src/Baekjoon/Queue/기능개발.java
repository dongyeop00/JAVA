package Baekjoon.Queue;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        solution(progresses, speeds);
    }

    private static void solution(int[] progresses, int[] speeds){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<progresses.length; i++){
            int num = 100 - progresses[i];
            int day = (num % speeds[i] == 0) ? (num/speeds[i]) : (num/speeds[i] + 1);
            queue.offer(day);
        }

        while(!queue.isEmpty()){
            int temp = queue.poll();
            int count = 1;

            while(!queue.isEmpty() && queue.peek() <= temp){
                queue.poll();
                count++;
            }

            list.add(count);
        }

        System.out.println(list);
    }
}
