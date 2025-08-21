package Baekjoon.Graph.DFS;

import java.util.*;
import java.io.*;

public class 게임 {

	static int N, M, max = Integer.MIN_VALUE;
	static boolean flag = false;
	static int[][] map, dp;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				char temp = str.charAt(j);
				if(temp == 'H') map[i][j] = 0;
				else map[i][j] = temp - '0';
			}
		}
		
		DFS(0, 0, 1);
		
		if(flag) System.out.println(-1);
		else System.out.println(max);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void DFS(int x, int y, int count) {
		if(count > max) {
			max = count;
		}
		
		dp[x][y] = count;
		
		for(int i=0; i<4; i++) {
			int newX = x + dx[i] * map[x][y];
			int newY = y + dy[i] * map[x][y];
			
			if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
			if(map[newX][newY] == 0) continue;
			
			if(visited[newX][newY]) {
				flag = true;
				return;
			}
			
			if(dp[newX][newY] > count) continue;
			
			visited[newX][newY] = true;
			DFS(newX, newY, count+1);
			visited[newX][newY] = false;
		}
		
	}

}
