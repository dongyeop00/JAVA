package Baekjoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            queue.offer(i);
        }

        System.out.print("<");

        while(queue.size() > 1){
            for(int i=0; i<K-1; i++){
                int temp = queue.poll();
                queue.offer(temp);
            }
            System.out.print(queue.poll() + ", ");
        }
        System.out.print(queue.poll() + ">");
    }
}
