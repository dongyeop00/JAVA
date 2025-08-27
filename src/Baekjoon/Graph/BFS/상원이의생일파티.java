package Baekjoon.Graph.DFS;

import java.util.*;
import java.io.*;

public class 상원이의생일파티 {
	
	static int N, M, count;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			count = 0;
			
			graph = new ArrayList<>();
			for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			if(graph.get(1).size() == 0 ) {
				System.out.println("#" + testCase + " " + 0);
				continue;
			}else{
				BFS(1);
			}
			
			System.out.println("#" + testCase + " " + count);
		}
	}
	
	public static void BFS(int x) {
		boolean[] visited = new boolean[N+1];
		Queue<int[]> queue = new LinkedList<>();
		
		visited[1] = true;
		queue.offer(new int[] {1,0});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int node = current[0];
			int depth = current[1];
			
			if(depth != 0 && depth < 3) count++;
			
			for(int next : graph.get(node)) {
				if(!visited[next]) {
					visited[next] = true;
					queue.offer(new int[] {next, depth+1});
				}
			}
		}
	}

}
