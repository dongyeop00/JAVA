package Baekjoon.Graph.Dijkstra;

import java.util.*;
import java.io.*;

public class 특정한최단경로 {
	
	static int N, E;
	static int INF = 1_000_000_000;
	static long[] dist;
	static List<List<Edge>> graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new long[N+1];
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Edge(to, weight));
			graph.get(to).add(new Edge(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		long result1 = 0;
		result1 += dijkstra(1, v1);
		result1 += dijkstra(v1, v2);
		result1 += dijkstra(v2, N);
		
		long result2 = 0;
		result2 += dijkstra(1, v2);
		result2 += dijkstra(v2, v1);
		result2 += dijkstra(v1, N);
		
		if(result1 >= INF && result2 >= INF) {
			System.out.println(-1);
		}else {
			System.out.println(Math.min(result1, result2));
		}
		
		
	}
	
	public static long dijkstra(int start, int end) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		queue.offer(new Edge(start, 0));

		while(!queue.isEmpty()) {
			Edge current = queue.poll();
			
			if(dist[current.to] < current.weight) continue;
			
			for(Edge next : graph.get(current.to)) {
				if(dist[next.to] > dist[current.to] + next.weight) {
					dist[next.to] = dist[current.to] + next.weight;
					queue.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
		
		return dist[end] == INF ? INF : dist[end];
	}
	
	public static class Edge implements Comparable<Edge>{
		int to;
		long weight;
		
		Edge(int to, long weight){
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}
		
		
	}

}
