package Baekjoon.DP;

import java.util.*;
import java.io.*;

public class 일이삼더하기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[12];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4; i<12; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=0; testCase<TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(dp[N]);
		}
	}

}
