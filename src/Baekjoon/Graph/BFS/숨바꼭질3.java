package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = BFS(N, K);
        System.out.println(result);
    }

    public static int BFS(int N, int K){
        Deque<Integer> deq = new ArrayDeque<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, 1_000_000_000);

        deq.add(N);
        dist[N] = 0;

        while(!deq.isEmpty()){
            int current = deq.poll();

            if(current == K) return dist[current];

            if(current*2 <= 100000 && dist[current*2] > dist[current]){
                dist[current*2] = dist[current];
                deq.addFirst(current*2);
            }

            if(current+1 <= 100000 && dist[current+1] > dist[current] + 1){
                dist[current+1] = dist[current] + 1;
                deq.addLast(current+1);
            }

            if(current-1 >= 0 && dist[current-1] > dist[current] + 1){
                dist[current-1] = dist[current] + 1;
                deq.addLast(current-1);
            }
        }

        return 0;
    }

}
