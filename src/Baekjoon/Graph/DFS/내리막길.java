package Baekjoon.Graph.DFS;

import java.util.*;
import java.io.*;

public class 내리막길 {

	static int N, M;
	static int[][] map;
	static int[][] dp;
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
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		int result = DFS(0,0);
		System.out.println(result);
	}
	
	public static int DFS(int x, int y) {
		if(x == N-1 && y == M-1) {
			return 1;
		}
		
		// 해당 좌표 방문한적이 없는경우
		if(dp[x][y] == -1) {
			
			dp[x][y] = 0;
			
			for(int i=0; i<4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
				if(map[x][y] > map[newX][newY]) {
					dp[x][y] += DFS(newX, newY);
				}
			}
		}
		
		
		return dp[x][y];
	}

}
