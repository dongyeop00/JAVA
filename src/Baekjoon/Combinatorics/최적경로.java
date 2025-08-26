package Baekjoon.Combinatorics;

import java.util.*;
import java.io.*;

public class 최적경로 {
	
	static int N, min;
	static Position[] customer, select;
	static Position home, company;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			home = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			company = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			customer = new Position[N];
			select = new Position[N];
			visited = new boolean[N];
			
			for(int i=0; i<N; i++) {
				customer[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			min = Integer.MAX_VALUE;
			
			solve(0);
			
			System.out.println("#" + testCase + " " + min);
		}
	}
	
	public static void solve(int depth) {
		if(depth == N) {
			int answer = 0;
			//집에서 첫 고객까지 거리
			answer += dist(home.x, home.y, select[0].x, select[0].y);
			
			// 고객들끼리의 거리
			for(int i=0; i<N-1; i++) {
				answer += dist(select[i].x, select[i].y, select[i+1].x, select[i+1].y);
			}
			
			// 마지막 고객과 회사까지 거리
			answer += dist(select[N-1].x, select[N-1].y, company.x, company.y);
			
			min = Math.min(min, answer);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				select[depth] = customer[i];
				solve(depth+1);
				visited[i] = false;
			}
		}
		
	}
	
	public static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static class Position{
		int x;
		int y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
