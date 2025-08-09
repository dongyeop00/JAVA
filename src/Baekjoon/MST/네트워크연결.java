package Baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 네트워크연결 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int V = Integer.parseInt(bufferedReader.readLine());
        int E = Integer.parseInt(bufferedReader.readLine());

        List<List<Edge>> graph = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        long total = 0;
        int pick = 0;

        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        // 임의 정점 1번 선택 및 큐에 넣기
        visited[1] = true;
        for(Edge e : graph.get(1)){
            queue.offer(e);
        }

        while(!queue.isEmpty() && pick < V-1){
            Edge current = queue.poll();

            if(!visited[current.to]){
                visited[current.to] = true;
                total += current.weight;
                pick++;

                for(Edge e : graph.get(current.to)){
                    queue.offer(e);
                }
            }
        }

        System.out.println(total);
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
