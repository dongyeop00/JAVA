package Baekjoon.Graph.MST.Prim;

import java.util.*;
import java.io.*;

public class 하나로 {

	static int N;
	static double E;
	static int[] x;
	static int[] y;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			x = new int[N];
			y = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			long result = Math.round(Prim() * E);
			System.out.println("#" + testCase + " " + result);
		}
	}
	
	private static long Prim() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		long total = 0;
		int pick = 0;

		// 시작 정점 0
		visited[0] = true;
		pick = 0;
		
		// 0에서 다른 모든 정점으로의 간선을 pq에 삽입
		for(int i=1; i<N; i++) {
			long dx = x[0] - x[i];
			long dy = y[0] - y[i];
			long dist = dx * dx + dy * dy;
			queue.offer(new Edge(i, dist));
		}
		
		while(!queue.isEmpty() && pick < N-1) {
			Edge current = queue.poll();
			
			if(!visited[current.to]) {
				visited[current.to] = true;
				total += current.weight;
				pick++;
				
				for(int i=0; i<N; i++) {
					if(!visited[i]) {
						long dx = x[current.to] - x[i];
						long dy = y[current.to] - y[i];
						long dist = dx * dx + dy * dy;
						queue.offer(new Edge(i, dist));
					}
				}
			}
		}
		
		return total;
	}
	
	
	private static class Edge implements Comparable<Edge>{
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
