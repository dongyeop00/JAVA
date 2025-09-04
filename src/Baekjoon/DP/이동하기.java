package Baekjoon.DP;

import java.util.*;
import java.io.*;

public class 이동하기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<M+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				dp[i][j] = Math.max(dp[i][j-1], Math.max(dp[i-1][j], dp[i-1][j-1])) + map[i][j];
			}
		}
		
		System.out.println(dp[N][M]);
	}

}
