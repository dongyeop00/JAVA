package Baekjoon.Combinatorics;

import java.util.*;
import java.io.*;

public class 게리맨더링2 {

	static int N, min = Integer.MAX_VALUE;
	static int[] people;
	static List<List<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		boolean[] select = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			for(int j=0; j<count; j++) {
				int a = Integer.parseInt(st.nextToken()) - 1;
				graph.get(i).add(a);
				graph.get(a).add(i);
			}
		}
		
		subset(0, select);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	public static void subset(int depth, boolean[] select) {
		if(depth == N) {
			check(select);
			return;
		}
		
		select[depth] = true;
		subset(depth+1, select);
		
		select[depth] = false;
		subset(depth+1, select);
	}
	
	public static void check(boolean[] select) {
		int countA=0, countB=0;
		
		for(int i=0; i<N; i++) {
			if(select[i]) countA++;
			else countB++;
		}
		
		int checkA = BFS(countA, select, true);
		if(checkA < 0 ) return;
		int checkB = BFS(countB, select, false);
		if(checkB < 0 ) return;
		
		min = Math.min(min, Math.abs(checkA - checkB));
	}
	
	public static int BFS(int groupSize, boolean[] select, boolean condition) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		int groupCount = 0;
		int groupSum = 0;
		int start = -1;
		
		for(int i=0; i<N; i++) {
			if(select[i] == condition) {
				start = i;
				break;
			}
		}
		
		if(start < 0 ) return -1;
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			groupCount++;
			groupSum += people[current];
			
			for(int next : graph.get(current)) {
				if(select[next] == condition && !visited[next]) {
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
		
		return groupCount == groupSize ? groupSum : -1;
	}

}
