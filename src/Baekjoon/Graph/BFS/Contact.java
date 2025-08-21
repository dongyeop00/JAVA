package Baekjoon.Graph.BFS;
import java.io.*;
import java.util.*;

public class Contact {
	
	static boolean[] visited;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int testCase=1; testCase<=10; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			visited = new boolean[101];
			for(int i=0; i<=100; i++) {
				graph.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to =  Integer.parseInt(st.nextToken());
				
				graph.get(from).add(to);
			}
			
			int result = bfs(start);
			System.out.println("#" + testCase + " " + result);
		}
	}
	
	public static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		int max = 0;
		int size = 0;
		
		while(!queue.isEmpty()) {
			max = 0;
			size = queue.size();
			
			for(int i=0; i<size; i++) {
				int current = queue.poll();
				max = Math.max(current, max);
				for(int next : graph.get(current)) {
					if(!visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
			}
		}
		
		return max;
	}

}
