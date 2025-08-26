package Baekjoon.Graph.DFS;

import java.util.*;
import java.io.*;

public class 욕심쟁이판다 {
	
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result = Math.max(DFS(i,j), result);
			}
		}
		
		System.out.println(result);
	}
	
	public static int DFS(int x, int y) {
		// 이 칸의 최장 경로는 이미 구해놨으니 더 내려가지 말고 바로 써라
		if(dp[x][y] != 0) return dp[x][y];
		
		dp[x][y] = 1;
		
		for(int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
			if(map[x][y] < map[newX][newY]) {
				dp[x][y] = Math.max(dp[x][y], DFS(newX, newY) + 1);
			}
		}
		
		return dp[x][y];
	}

}
