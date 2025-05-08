package Baekjoon.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test_case=1; test_case<=10; test_case++){
            int T = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            int num = 1;

            for(int i=0; i<8; i++){
                queue.offer(sc.nextInt());
            }

            while(true){
                int temp = queue.poll() - num++;

                if(temp <= 0){
                    queue.offer(0);
                    break;
                }

                queue.offer(temp);

                if(num == 6){
                    num = 1;
                }
            }

            System.out.print("#" + T + " ");
            for(int i=0; i<8; i++){
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}
