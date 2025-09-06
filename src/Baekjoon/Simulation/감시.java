package Baekjoon.Simulation;

import java.util.*;
import java.io.*;

public class 감시 {
	
	static int N, M, min;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<CCTV> list = new ArrayList<>();
		int[][] map = new int[N][M];
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(1 <= map[i][j] && map[i][j] <= 5) {
					list.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
	
		dfs(0, map, list);
		System.out.println(min);
	}
	
	public static void dfs(int index, int[][] map, List<CCTV> list) {
		if(index == list.size()) {
			min = Math.min(min, check(map));
			return;
		}
		
		int x = list.get(index).x;
		int y = list.get(index).y;
		int type = list.get(index).type;
		
		if(type==1) {
			int[][] temp = copyMap(map);
			up(temp, x, y);
			dfs(index+1, temp, list);
			
			temp = copyMap(map);
			down(temp, x, y);
			dfs(index+1, temp, list);
			
			temp = copyMap(map);
			left(temp, x, y);
			dfs(index+1, temp, list);
			
			temp = copyMap(map);
			right(temp, x, y);
			dfs(index+1, temp, list);
			
		}else if(type==2) {
			int[][] temp = copyMap(map);
			up(temp, x, y);
			down(temp, x, y);
			dfs(index+1, temp, list);
			
			temp = copyMap(map);
			right(temp, x, y);
			left(temp, x, y);
			dfs(index+1, temp, list);
			
		}else if(type==3) {
			int[][] temp = copyMap(map);
			up(temp, x, y);
			right(temp, x, y);
			dfs(index+1, temp, list);
			
			temp = copyMap(map);
			right(temp, x, y);
			down(temp, x, y);
			dfs(index+1, temp, list);
			
			temp = copyMap(map);
			down(temp, x, y);
			left(temp, x, y);
			dfs(index+1, temp, list);
			
			temp = copyMap(map);
			left(temp, x, y);
			up(temp, x, y);
			dfs(index+1, temp, list);
			
		}else if(type==4) {
			int[][] temp = copyMap(map);
			left(temp, x, y);
			up(temp, x, y);
			right(temp, x, y);
			dfs(index+1, temp, list);
			
			temp = copyMap(map);
			up(temp, x, y);
			right(temp, x, y);
			down(temp, x, y);
			dfs(index+1, temp, list);
			
			temp = copyMap(map);
			right(temp, x, y);
			down(temp, x, y);
			left(temp, x, y);
			dfs(index+1, temp, list);
			
			temp = copyMap(map);
			down(temp, x, y);
			left(temp, x, y);
			up(temp, x, y);
			dfs(index+1, temp, list);
		}else {
			int[][] temp = copyMap(map);
			up(temp, x, y);
			right(temp, x, y);
			down(temp, x, y);
			left(temp, x, y);
			dfs(index+1, temp, list);
		}
	}
	
	public static void up(int[][] map, int x, int y) {
		for(int i=x-1; i>=0; i--) {
			if(i < 0) return;
			if(map[i][y] == 6) return;
			else if(map[i][y] == 0) map[i][y] = 9;
		}
	}
	
	public static void down(int[][] map, int x, int y) {
		for(int i=x+1; i<N; i++) {
			if(x >= N) return;
			if(map[i][y] == 6) return;
			else if(map[i][y] == 0) map[i][y] = 9;
		}
	}
	
	public static void left(int[][] map, int x, int y) {
		for(int i=y-1; i>=0; i--) {
			if(i < 0) return;
			if(map[x][i] == 6) return;
			else if(map[x][i] == 0) map[x][i] = 9;
		}
	}
	
	public static void right(int[][] map, int x, int y) {
		for(int i=y+1; i<M; i++) {
			if(i >= M) return;
			if(map[x][i] == 6) return;
			else if(map[x][i] == 0) map[x][i] = 9;
		}
	}
	
	public static int check(int[][] map) {
		int count = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static int[][] copyMap(int[][] map){
		int[][] copy = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		return copy;
	}
	
	public static void display(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======");
	}
	
	public static class CCTV{
		int x;
		int y;
		int type;
		
		CCTV(int x, int y, int type){
			this.x = x;
			this.y = y;
			this.type= type;
		}
	}

}
