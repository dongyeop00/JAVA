package Baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int V = Integer.parseInt(stringTokenizer.nextToken());
        int E = Integer.parseInt(stringTokenizer.nextToken());

        List<List<Edge>> graph = new ArrayList<>();

        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());
            int C = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(A).add(new Edge(B, C));
            graph.get(B).add(new Edge(A, C));
        }

        boolean[] visited = new boolean[V+1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        long total = 0;
        int pick = 0;

        // 임의 정점 1번부터 시작
        visited[1] = true;
        for(Edge e : graph.get(1)){
            queue.offer(e);
        }

        // 큐가 비어있을 때까지 && V-1번까지 반복
        while(!queue.isEmpty() && pick < V-1){
            Edge current = queue.poll();

            if(!visited[current.to]) {
                visited[current.to] = true;
                total += current.w;
                pick++;

                for(Edge next : graph.get(current.to)){
                    queue.offer(next);
                }
            }
        }

        System.out.println(total);
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int w;

        Edge(int to, int w){
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
}
