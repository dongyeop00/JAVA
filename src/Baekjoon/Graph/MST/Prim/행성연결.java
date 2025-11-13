package Baekjoon.Graph.MST.Prim;

import java.util.*;
import java.io.*;

public class 행성연결 {

	static int[][] map;
	static List<List<Edge>> graph = new ArrayList<>();
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == j) continue;
				
				graph.get(i).add(new Edge(j, map[i][j]));
			}
		}
		
		long mst = prim();
		System.out.println(mst);
	}
	
	public static long prim() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		long total = 0;
		int pick = 0;
		
		for(Edge e : graph.get(1)) {
			queue.offer(e);
		}
		
		visited[1] = true;
		
		while(!queue.isEmpty() && pick < N-1) {
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
	
	public static class Edge implements Comparable<Edge>{
		int to;
		int weight;
		
		Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

}
