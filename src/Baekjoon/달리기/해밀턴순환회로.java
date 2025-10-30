package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 해밀턴순환회로 {
	
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int minPath = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(minPath);
	}
	
	public static void dfs(int index, int start, int distance) {
		
		if(distance > minPath) {
			return;
		}
		
		if(index == N-1) {
			if(map[start][0] != 0) {
				minPath = Math.min(minPath, distance + map[start][0]);
			}
			return;
		}
		
		for(int i=1; i<N; i++) {
			if(map[start][i] != 0 && !visited[i]) {
				visited[i] = true;
				dfs(index+1, i, distance + map[start][i]);
				visited[i] = false;
			}
		}
	}

}
