package Baekjoon.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 해킹 {

    static int n, d, c;
    static int INF = 1_000_000_000;
    static int count, time;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase=0; testCase<T; testCase++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); // 정점 개수
            d = Integer.parseInt(st.nextToken()); // 엣지 개수
            c = Integer.parseInt(st.nextToken()); // 시작 정점

            // 그래프 정점개수로 세팅
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph.get(from).add(new Edge(to, weight));
            }

            count = 0;
            time = 0;

            dijstra(c);
            System.out.println(count + " " + time);
        }
    }

    public static void dijstra(int start){
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        queue.offer(new Edge(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Edge current = queue.poll();

            if(visited[current.to]) continue;
            visited[current.to] = true;

            for(Edge e : graph.get(current.to)){
                if(dist[e.to] >= dist[current.to] + e.weight){
                    dist[e.to] = dist[current.to] + e.weight;
                    queue.offer(new Edge(e.to, dist[e.to]));
                }
            }
        }

        for(int num : dist){
            if(num == INF) continue;
            if(num >= 0){
                count++;
                time = Math.max(num, time);
            }
        }

    }

    public static class Edge implements Comparable<Edge>{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
