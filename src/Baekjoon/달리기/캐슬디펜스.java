package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 캐슬디펜스 {

	static int N, M, D;
	static int[][] map;
	static int[] dx = {0, -1, 0};
	static int[] dy = {-1, 0, 1};
	static Archer[] archers = new Archer[3];
	static int maxKill = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0);
		System.out.println(maxKill);
	}
	
	public static void solve(int depth, int index) {
		if(depth==3) {
			maxKill = Math.max(maxKill, simulation());
			return;
		}
		
		for(int i=index; i<M; i++) {
			archers[depth] = new Archer(N-1, i);
			solve(depth+1, i+1);
		}
	}
	
	public static int simulation() {
		
		int[][] copyMap = copy();
		int count = 0;
		
		for(int time=0; time<N; time++) {
			boolean[][] enemies = new boolean[N][M];
			
			for(Archer a : archers) {
				Enemy enemy= kill(copyMap, a);
				if(enemy != null) {
					enemies[enemy.x][enemy.y] = true;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(enemies[i][j]) {
						copyMap[i][j] = 0;
						count++;
					}
				}
			}
			
			for(int i=N-1; i>=1; i--) {
				for(int j=0; j<M; j++) {
					copyMap[i][j] = copyMap[i-1][j];
				}
			}
			
			for(int i=0; i<M; i++) {
				copyMap[0][i] = 0;
			}
		}
		
		return count;
	}
	
	public static Enemy kill(int[][] copyMap, Archer a) {
		Queue<Archer> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new Archer(a.x, a.y, 1));
		visited[a.x][a.y] = true;
		
		while(!queue.isEmpty()) {
			Archer current = queue.poll();
			
			if(copyMap[current.x][current.y] == 1) {
				return new Enemy(current.x, current.y);
			}
			
			for(int i=0; i<3; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
				if(visited[newX][newY]) continue;
				if(current.dist+1 > D) continue;
				
				visited[newX][newY] = true;
				queue.offer(new Archer(newX, newY, current.dist+1));
			}
		}
		
		return null;
	}
	
	public static int[][] copy(){
		int[][] copyMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		return copyMap;
	}
	
	static class Enemy{
		int x;
		int y;
		
		Enemy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class Archer{
		int x;
		int y;
		int dist;
		
		Archer(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		Archer(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

}
