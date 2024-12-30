package Baekjoon.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            queue.offer(i);
        }

        while(queue.size() != 1){
            queue.poll();
            int temp = queue.poll();
            queue.offer(temp);
        }

        System.out.println(queue.peek());
    }
}
