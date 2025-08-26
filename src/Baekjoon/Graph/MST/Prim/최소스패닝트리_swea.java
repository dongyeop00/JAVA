package Baekjoon.Graph.MST.Prim;

import java.util.*;
import java.io.*;

public class 최소스패닝트리_swea {

	static int V, E;
	static List<List<Edge>> graph;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for(int i=0; i<=V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				graph.get(from).add(new Edge(to, weight));
				graph.get(to).add(new Edge(from, weight));
			}
			
			long result = Prim();
			System.out.println("#" + testCase + " " + result);
		}
	}
	
	private static long Prim() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		//시작정점 1;
		visited[1] = true;
		for(Edge e : graph.get(1)) {
			queue.offer(e);
		}
		
		long total = 0;
		int pick = 0;
		
		while(!queue.isEmpty() && pick < V-1) {
			Edge current = queue.poll();
			
			if(!visited[current.to]) {
				visited[current.to] = true;
				total += current.weight;
				pick++;
				
				for(Edge e : graph.get(current.to)) {
					queue.offer(e);
				}
			}
		}
		
		return total;
	}
	
	private static class Edge implements Comparable<Edge>{
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
