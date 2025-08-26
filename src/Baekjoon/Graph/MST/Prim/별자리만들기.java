package Baekjoon.Graph.MST.Prim;

import java.util.*;
import java.io.*;

public class 별자리만들기 {

	static int N;
	static double[] x;
	static double[] y;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		x = new double[N];
		y = new double[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Double.parseDouble(st.nextToken());
			y[i] = Double.parseDouble(st.nextToken());
		}
		
		double result = Prim();
		System.out.println(result);
	}

	private static double Prim() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		double total = 0;
		int pick = 0;
		
		visited[0] = true;
		for(int i=1; i<N; i++) {
			double dx = Math.pow(x[0]-x[i], 2); 
			double dy = Math.pow(y[0]-y[i], 2);
			double weight = Math.sqrt(dx + dy);
			queue.offer(new Edge(i, weight));
		}
		
		while(!queue.isEmpty() && pick < N-1) {
			Edge current = queue.poll();
			
			if(visited[current.to]) continue;
			visited[current.to] = true;
			total += current.weight;
			pick++;
			
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					double dx = Math.pow(x[current.to]-x[i], 2); 
					double dy = Math.pow(y[current.to]-y[i], 2);
					double weight = Math.sqrt(dx + dy);
					queue.offer(new Edge(i, weight));
				}
			}
		}
		
		return total;
	}
	
	private static class Edge implements Comparable<Edge>{
		int to;
		double weight;
		
		Edge(int to, double weight){
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}
	}
}
