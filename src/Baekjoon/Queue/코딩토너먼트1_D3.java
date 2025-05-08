package Baekjoon.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 코딩토너먼트1_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case<=T; test_case++){
            int num = (int) Math.pow(2, sc.nextInt());
            int sum = 0;
            Queue<Integer> queue = new LinkedList<>();

            for(int i=0; i<num; i++){
                queue.offer(sc.nextInt());
            }

            while(num > 1){
                for(int i=0; i<num/2; i++){
                    int a = queue.poll();
                    int b = queue.poll();
                    int max = Math.max(a,b);
                    int min = Math.min(a,b);
                    queue.offer(max);
                    sum += max - min;
                }
                num /= 2;
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
