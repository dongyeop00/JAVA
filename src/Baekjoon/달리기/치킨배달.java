package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 치킨배달 {
	
	static int N, M;
	static int[][] map;
	static List<Position> chicken = new ArrayList<>();
	static List<Position> home = new ArrayList<>();
	static Position[] select;
	static int minLength;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		select = new Position[M];
		minLength = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					chicken.add(new Position(i,j));
				}else if(map[i][j] == 1) {
					home.add(new Position(i,j));
				}
			}
		}
		
		Combination(0, 0);
		System.out.println(minLength);
	}
	
	public static void Combination(int depth, int index) {
		if(depth == M) {
			int sum = 0;
			
			for(Position h : home) {
				int min = Integer.MAX_VALUE;
				for(Position c : select) {
					min = Math.min(min, distance(c.x, c.y, h.x, h.y));
				}
				sum += min;
			}
			
			minLength = Math.min(minLength, sum);
			return;
		}
		
		for(int i=index; i<chicken.size(); i++) {
			select[depth] = chicken.get(i);
			Combination(depth+1, i+1);
		}
	}
	
	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	static class Position{
		int x;
		int y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
