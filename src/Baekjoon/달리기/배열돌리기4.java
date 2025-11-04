package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 배열돌리기4 {
	
	static int N, M, K;
	static int[][] map;
	static Spin[] spins;
	static Spin[] select;
	static boolean[] visited;
	static int min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		spins = new Spin[K];
		select = new Spin[K];
		visited = new boolean[K];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int layer = Integer.parseInt(st.nextToken());
			
			spins[i] = new Spin(x-1, y-1, layer);
		}
		
		min = Integer.MAX_VALUE;
		solve(0);
		System.out.println(min);
	}
	
	public static void solve(int depth) {
		if(depth == K) {
			int[][] spinMap = spinArray();
			int val = getMinRowSum(spinMap);
			min = Math.min(min, val);
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(!visited[i]) {
				visited[i] = true;
				select[depth] = spins[i];
				solve(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static int[][] spinArray() {
		int[][] copyMap = copy(map);
		
		// K번 만큼 돌린다.
		for(int i=0; i<K; i++) {
			Spin current = select[i];
			
			for(int layer=1; layer <= current.layer; layer++) {
				
				int startX = current.x - layer;
				int startY = current.y - layer;
				int endX = current.x + layer;
				int endY = current.y + layer;
				int temp = copyMap[startX][startY];
				
				// ↑
				for(int x = startX+1; x <= endX; x++) {
					copyMap[x-1][startY] = copyMap[x][startY];
				}
					
				// ←
				for(int y = startY+1; y <= endY; y++) {
					copyMap[endX][y-1] = copyMap[endX][y];
				}
				
				// ↓
				for(int x = endX-1; x >= startX; x--) {
					copyMap[x+1][endY] = copyMap[x][endY];
				}
				
				// →
				for(int y = endY-1; y >= startY; y--) {
					copyMap[startX][y+1] = copyMap[startX][y];
				}
				
				copyMap[startX][startY+1] = temp;
			}
		}
		
		return copyMap;
	}
	
	static int getMinRowSum(int[][] arr) {
	    int best = Integer.MAX_VALUE;
	    for (int i=0; i<N; i++) {
	        int sum = 0;
	        for (int j=0; j<M; j++) {
	        	sum += arr[i][j];
	        }
	        best = Math.min(best, sum);
	    }
	    return best;
	}
	
	public static int[][] copy(int[][] map){
		int[][] copyMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		return copyMap;
	}
	
	public static void display(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("====");
	}
	
	static class Spin{
		int x;
		int y;
		int layer;
		
		Spin(int x, int y, int layer){
			this.x = x;
			this.y = y;
			this.layer = layer;
		}
	}

}
