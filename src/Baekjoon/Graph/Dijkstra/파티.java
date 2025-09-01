package Baekjoon.Graph.Dijkstra;

import java.util.*;
import java.io.*;

public class 파티 {
	
	static int INF = 1_000_000_000;
	static int N, M, X;
	static List<List<Edge>> graph = new ArrayList<>();
	static List<List<Edge>> rev = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
			rev.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Edge(to, weight));
			rev.get(to).add(new Edge(from, weight));
		}
		
		int[] NodeToX = dijkstra(X, graph);
		int[] XtoNode = dijkstra(X, rev);
		int max = 0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, NodeToX[i] + XtoNode[i]);
		}
		System.out.println(max);
	}
	
	public static int[] dijkstra(int start, List<List<Edge>> g) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(dist, INF);
		
		queue.offer(new Edge(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()){
			Edge current = queue.poll();
			
			if(visited[current.to]) continue;
			visited[current.to] = true;
			
			for(Edge e : g.get(current.to)) {
				if(dist[e.to] >= dist[current.to] + e.weight) {
					dist[e.to] = dist[current.to] + e.weight;
					queue.offer(new Edge(e.to, dist[e.to]));
				}
			}
		}
		
		return dist;
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
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

}
