package Baekjoon.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=V; i++) graph.add(new ArrayList<>());

        int start = Integer.parseInt(br.readLine());

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(to, weight));
        }

        int[] dist = new int[V+1];
        boolean[] visited = new boolean[V+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        dist[start] = 0;
        queue.offer(new Edge(start, 0));

        while(!queue.isEmpty()){
            Edge current = queue.poll();

            if(visited[current.to]) continue;
            visited[current.to] = true;

            for(Edge e : graph.get(current.to)){
                if(!visited[e.to] && dist[e.to] > dist[current.to] + e.weight){
                    dist[e.to] = dist[current.to] + e.weight;
                    queue.offer(new Edge(e.to, dist[e.to]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

    public static class Edge implements Comparable<Edge>{
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
