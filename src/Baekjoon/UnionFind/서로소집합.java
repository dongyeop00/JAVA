package Baekjoon.UnionFind;

import java.util.*;
import java.io.*;

public class 서로소집합 {
	
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];

			make();
			String answer = "";
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(command == 0) {
					union(a,b);
				}else {
					if(find(a) == find(b)) {
						answer += "1";
					}else {
						answer += "0";
					}
				}
			}
			
			System.out.println("#" + testCase + " " + answer);
		}
	}
	
	// 자신을 자신의 부모로 초기화 (자신이 곧 루트, 대표자가 됨)
	public static void make() {
		for(int i=0; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	// a가 속한 대표자 찾기
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]); // 패스 압축 후
	}
	
	// 합치기
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 이미 같은 집합이므로 합치기 불가
		if(aRoot == bRoot) {
			return;
		}
		
		// 합치기 성공
		parents[bRoot] = aRoot;
	}

}
