package Baekjoon.달리기;

import java.io.*;
import java.util.*;

public class 나무높이 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			int maxHeight = Integer.MIN_VALUE;
			int minDay = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, tree[i]);
			}
			
			minDay = watering(N, tree, maxHeight);
			minDay = Math.min(minDay, watering(N, tree, maxHeight+1));
			
			System.out.println("#" + testCase + " " + minDay);
		}
	}
	
	public static int watering(int N, int[] tree, int maxHeight) {
		int day = 0, one = 0, two = 0;
		
		for(int i=0; i<N; i++) {
			one += (maxHeight - tree[i]) % 2;
			two += (maxHeight - tree[i]) / 2;
		}
		
		int min = Math.min(one, two);
		one -= min;
		two -= min;
		day += min*2;
		
		//2*n - 1
		if(two == 0) {
			day += 2*one - 1;
		}
		
		//(n+1)+(n-1)/3
		if(one == 0) {
			day += (two+1) + (two-1) / 3;
		}
		
		return day;
	}


}
