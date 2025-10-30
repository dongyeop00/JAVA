package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 말이되고픈원숭이 {
	
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = BFS(0, 0);
		System.out.println(result);
	}
	
	public static int BFS(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		
		queue.offer(new Position(x, y, 0, 0));
		visited[x][y][0] = true;
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			if(current.x == H-1 && current.y == W-1) {
				return current.dist;
			}
			
			// 말로 이동하기
			if(current.horse < K) {
				for(int i=0; i<8; i++) {
					int newX = current.x + hx[i];
					int newY = current.y + hy[i];
					
					if(newX < 0 || newY < 0 || newX >= H || newY >= W) continue;
					if(map[newX][newY] == 1) continue;
					if(visited[newX][newY][current.horse+1]) continue;
					
					queue.offer(new Position(newX, newY, current.dist + 1, current.horse+1));
					visited[newX][newY][current.horse+1] = true;
				}
			}
			
			// 그냥 걸어서 이동하기
			for(int i=0; i<4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= H || newY >= W) continue;
				if(map[newX][newY] == 1) continue;
				if(visited[newX][newY][current.horse]) continue;
				
				queue.offer(new Position(newX, newY, current.dist+1, current.horse));
				visited[newX][newY][current.horse] = true;
			}
		}
		
		return -1;
	}
	
	public static class Position{
		int x;
		int y;
		int dist;
		int horse;
		
		Position(int x, int y, int dist, int horse){
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.horse = horse;
		}
	}

}
