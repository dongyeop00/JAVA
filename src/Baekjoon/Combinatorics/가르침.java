package Baekjoon.Combinatorics;

import java.util.*;
import java.io.*;

public class 가르침 {
	
	static int N, K;
	static boolean[] visited;
	static String[] words;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 가운데 글자만 저장함
		words = new String[N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			words[i] = s.substring(4, s.length()-4);
		}
		
		// base가 5개가 필요하니 5개 미만으로 배울 수 있으면 아무것도 못 읽음
		if(K < 5) {
			System.out.println(0);
			return;
		}
		
		// 알파벳 26개 배울 수 있으면 전부 다 읽을 수 있음.
		if(K == 26) {
			System.out.println(N);
			return;
		}
		
		// 필수 5글자
		visited = new boolean[26];
		visited['a' - 'a'] = true;
		visited['c' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['i' - 'a'] = true;
		
		backTracking(0, 0);
		System.out.println(max);
	}
	
	public static void backTracking(int depth, int index) {
		if(depth == K - 5) {
			max = Math.max(max, check(visited));
			return;
		}
		
		for(int i=index; i<26; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backTracking(depth+1, i+1);
				visited[i] = false;
			}
		}
	}
	
	public static int check(boolean[] visited) {
		int count = 0;
		
		for(int i=0; i<N; i++) {
			boolean ok = true;
			for(int j=0; j<words[i].length(); j++) {
				if(!visited[words[i].charAt(j) - 'a']) {
					ok = false;
				}
			}
			if(ok) {
				count++;
			}
		}
		
		return count;
	}

}
