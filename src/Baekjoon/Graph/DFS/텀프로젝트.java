package Baekjoon.Graph.DFS;

import java.util.*;
import java.io.*;

public class 텀프로젝트 {
	
	static int N;
	static int[] students;
	static boolean[] visited;
	static boolean[] finished;
	static int count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase<T; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			students = new int[N+1];
			visited = new boolean[N+1];
			finished = new boolean[N+1];
			count = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=N; i++) {
				DFS(i);
			}
			
			System.out.println(N - count);
		}
	}
	
	public static void DFS(int current) {
		if(visited[current]) {
			return;
		}
		
		visited[current] = true;
		int next = students[current];
		
		// 다음 노드를 방문하지 않았다면
		if(!visited[next]) {
			DFS(next);
		}
		// 다음 노드를 방문 했다면 
		else {
			// 다음 노드를 방문 했는데, 다음 노드가 끝나지 않았다면
			if(finished[next] == false) {
				count++;
				
				// 이전 노드들도 count
				for(int i=next; i != current; i=students[i]) {
					count++;
				}
			}
		}
		
		finished[current] = true;
	}
	


}
