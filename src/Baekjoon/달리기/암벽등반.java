package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 암벽등반 {
	
	static int N, M;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int sx, sy, ex, ey;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						sx = i;
						sy = j;
					}else if(map[i][j] == 3) {
						ex = i;
						ey = j;
					}
				}
			}
			
			int minLevel = 0;
			for(int level=0; level<N; level++) {
				if(BFS(level)) {
					minLevel = level;
					break;
				}
			}
			
			System.out.println("#" + testCase + " " + minLevel);
		}
	}
	
	public static boolean BFS(int level) {
		Queue<Position> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new Position(sx, sy));
		visited[sx][sy] = true;
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			if(current.x == ex && current.y == ey) {
				return true;
			}
			
			// 오른쪽 이동
			if(current.y + 1 < M && map[current.x][current.y+1] != 0 && !visited[current.x][current.y+1]) {
				visited[current.x][current.y+1] = true;
				queue.offer(new Position(current.x, current.y+1));
			}
			
			// 왼쪽 이동
			if(current.y - 1 >= 0 && map[current.x][current.y-1] != 0 && !visited[current.x][current.y-1]) {
				visited[current.x][current.y-1] = true;
				queue.offer(new Position(current.x, current.y-1));
			}
			
			for(int i=0; i<=level; i++) {
				//위로 이동
				if(current.x - i >= 0 && map[current.x-i][current.y] != 0 && !visited[current.x-i][current.y]) {
					visited[current.x - i][current.y] = true;
					queue.offer(new Position(current.x - i, current.y));
				}
				
				//아래로 이동
				if(current.x + i < N && map[current.x+i][current.y] != 0 && !visited[current.x+i][current.y]) {
					visited[current.x + i][current.y] = true;
					queue.offer(new Position(current.x + i, current.y));
				}
			}
		}
		
		return false;
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
