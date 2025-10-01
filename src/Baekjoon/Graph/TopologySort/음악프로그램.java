package Baekjoon.Graph.TopologySort;

import java.util.*;
import java.io.*;

public class 음악프로그램 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> graph = new ArrayList<>();
		int[] line = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int start = 0;
			
			for(int j=0; j<num; j++) {
				int to = 0;
				
				if(j == 0) {
					start = Integer.parseInt(st.nextToken());
				}else {
					to = Integer.parseInt(st.nextToken());
					graph.get(start).add(to);
					line[to]++;
					start = to;
				}
				
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		int visited = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			if(line[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			visited++;
			sb.append(current).append("\n");
			
			for(int next : graph.get(current)) {
				line[next]--;
				
				if(line[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		if(visited == N) {
			System.out.println(sb);
		}else {
			System.out.println(0);
		}
		
	}

}
