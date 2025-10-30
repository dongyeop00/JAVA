package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 줄세우기 {
	
	static int N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	static int[] line;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		line = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
			
			line[B]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(line[i] == 0) {
				queue.offer(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			sb.append(current).append(" ");
			
			for(int next : graph.get(current)) {
				line[next]--;
				
				if(line[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
