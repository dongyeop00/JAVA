package Baekjoon.Graph.BFS;

import java.io.*;
import java.util.*;

public class Baek1389 {

    static List<List<Integer>> graph = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        int min = Integer.MAX_VALUE;
        int[] answer = new int[N+1];

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for(int i=1; i<=N; i++) {
            int sum = BFS(i);
            answer[i] = sum;
            min = Math.min(min, sum);
        }

        for(int i=0; i<=N; i++) {
            if(answer[i] == min) {
                System.out.println(i);
                return;
            }
        }

    }

    public static int BFS(int x) {
        boolean[] visited = new boolean[N+1];
        int[] disArray = new int[N+1];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(x, 0));
        visited[x] = true;

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int currentX = current.x;
            int currentdis = current.distance;

            for(int n : graph.get(currentX)) {
                if(!visited[n]) {
                    visited[n] = true;
                    disArray[n] = currentdis + 1;
                    queue.offer(new Node(n, currentdis+1));
                }
            }
        }

        int sum = 0;
        for(int i=0; i<=N; i++) {
            sum += disArray[i];
        }

        return sum;
    }

    static class Node{
        int x;
        int distance;

        public Node(int x, int distance) {
            this.x = x;
            this.distance = distance;
        }
    }

}

