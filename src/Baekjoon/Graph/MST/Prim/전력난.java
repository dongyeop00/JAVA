package Baekjoon.Graph.MST.Prim;

import java.util.*;
import java.io.*;

public class 전력난 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int sum = 0;
			
			if(V == 0 && E == 0) break;
			
			List<List<Edge>> graph = new ArrayList<>();
			for(int i=0; i<=V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				sum += weight;
				
				graph.get(from).add(new Edge(to, weight));
				graph.get(to).add(new Edge(from, weight));
			}
			
			int result = sum - Prim(V, E, graph);
			
			System.out.println(result);
		}
		
	}
	
	public static int Prim(int V, int E, List<List<Edge>> graph) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		int total = 0;
		int pick = 0;
		
		visited[0] = true;
		for(Edge e : graph.get(0)) {
			queue.offer(e);
		}
		
		while(!queue.isEmpty() && pick < V-1) {
			Edge current = queue.poll();
			
			if(visited[current.to]) continue;
			visited[current.to] = true;
			total += current.weight;
			pick++;
			
			for(Edge e : graph.get(current.to)) {
				if(!visited[e.to]) {
					queue.offer(e);
				}
			}
		}
		
		return total;
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
