package Baekjoon.Graph.Dijkstra;

import java.util.*;
import java.io.*;

public class 최소비용구하기2 {
	
	static int N, M;
	static int INF = 1_000_000_000;
	static List<Integer> path = new ArrayList<>();
	static List<List<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int result = dijkstra(start, end);
		System.out.println(result);
		System.out.println(path.size());
		for(int num : path) System.out.print(num + " ");
	}
	
	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[] dist = new int[N+1];
		int[] prev = new int[N+1];
		

		Arrays.fill(dist, INF);
		Arrays.fill(prev, -1);
		
		queue.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			if(dist[current.to] < current.weight) continue;
			
			for(Node next : graph.get(current.to)) {
				if(dist[next.to] > dist[current.to] + next.weight) {
					dist[next.to] = dist[current.to] + next.weight;
					prev[next.to] = current.to;
					queue.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		for(int i = end; i != -1; i = prev[i]) {
			path.add(i);
		}
		
		Collections.reverse(path);
		
		return dist[end];
	}

	public static class Node implements Comparable<Node>{
		int to;
		int weight;
		
		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

}
