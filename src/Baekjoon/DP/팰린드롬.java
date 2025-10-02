package Baekjoon.DP;

import java.util.*;
import java.io.*;

public class 팰린드롬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		boolean[][] dp = new boolean[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 길이가 1일 때는 모두 true
		for(int i=1; i<=N; i++) {
			dp[i][i] = true;
		}
		
		// 길이가 2일 때는 체크
		for(int i=1; i<N; i++) {
			if(arr[i] == arr[i+1]) {
				dp[i][i+1] = true;
			}
		}
		
		// 길이가 3이상일 때
		for (int len = 3; len <= N; len++) {
			// 길이가 3일때 [1,2,3] [2,3,4], [3,4,5], [4,5,6], [5,6,7]... 이렇게 채워야됨
		    for (int i = 1; i + len - 1 <= N; i++) {
		        int j = i + len - 1;
		        if (arr[i] == arr[j] && dp[i+1][j-1]) dp[i][j] = true;
		    }
		}

		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if(dp[S][E]) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
