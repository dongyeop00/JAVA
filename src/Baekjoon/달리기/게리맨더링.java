package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 게리맨더링 {
	
	static int N;
	static int[] people;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		people = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		visited = new boolean[N+1];
		subset(1);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	public static void subset(int index) {
		if(index == N+1) {
			solve();
			return;
		}
		
		visited[index] = true;
		subset(index+1);
		
		visited[index] = false;
		subset(index+1);
	}
	
	public static void solve() {
		int Acount = 0;
		int Bcount = 0;
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) {
				Acount++;
			}else {
				Bcount++;
			}
		}
		
		if(Acount == 0 || Bcount == 0) return;
		
		int Asum = BFS(Acount, true);
		if(Asum < 0) return;
		int Bsum = BFS(Bcount, false);
		if(Bsum < 0) return;
		
		min = Math.min(min, Math.abs(Asum - Bsum));
	}
	
	public static int BFS(int Acount, boolean condition) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] check = new boolean[N+1];
		
		int start = -1;
		for(int i=1; i<=N; i++) {
			if(visited[i] == condition) {
				start = i;
				break;
			}
		}
		
		if(start == -1) {
			return -1;
		}
		
		queue.offer(start);
		check[start] = true;
		int visitedSum = 0;
		int visitedCount = 0;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			visitedCount++;
			visitedSum += people[current];
			
			for(int next : graph.get(current)) {
				if(visited[next] == condition && !check[next]) {
					queue.offer(next);
					check[next] = true;
				}
			}
		}
		
		
		return visitedCount == Acount ? visitedSum : -1;
	}

}
