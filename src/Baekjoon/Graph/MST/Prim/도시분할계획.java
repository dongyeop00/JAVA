package Baekjoon.Graph.MST.Prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시분할계획 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int V = Integer.parseInt(stringTokenizer.nextToken());
        int E = Integer.parseInt(stringTokenizer.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        long max = 0;
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

            graph.get(a).add(new Edge(b ,c));
            graph.get(b).add(new Edge(a, c));
        }

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
                max = Math.max(max, current.weight);

                for(Edge e : graph.get(current.to)){
                    queue.offer(e);
                }
            }
        }
        System.out.println(total - max);
    }

    static class Edge implements Comparable<Edge>{
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
