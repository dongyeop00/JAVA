package Baekjoon.Graph.DFS;

import java.util.*;
import java.io.*;

public class 구슬탈출2 {

	static int N, M, count;
	static int redX, redY;
	static int blueX, blueY;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static char[][] map;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = Integer.MAX_VALUE;
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'B') {blueX = i; blueY = j;}
				else if(map[i][j] == 'R') {redX = i; redY = j;}
			}
		}
			
		dfs(0, redX, redY, blueX, blueY);
		System.out.println(count == Integer.MAX_VALUE ? -1 : count);
	}
	
	public static void dfs(int depth, int rx, int ry, int bx, int by) {
		if(depth >= count) {
			return;
		}
		
		if(depth >= 10) {
			return;
		}
		
		for(int i=0; i<4; i++) {
			Result red = roll(rx, ry, i);
			Result blue = roll(bx, by, i);
			
			if(blue.isHole) continue;
			
			if(red.isHole) {
				count = Math.min(count, depth+1);
				return;
			}
			
			// 같은 자리일 때 처리
			if(red.x == blue.x && red.y == blue.y) {
				if(red.dist > blue.dist) { // red가 더 많이 이동했다 -> red가 뒤에 있었다.
					red.x -= dx[i];
					red.y -= dy[i];
				}else {
					blue.x -= dx[i];
					blue.y -= dy[i];
				}
			}
			
			if(red.x == rx && red.y == ry && blue.x == bx && blue.y == by) continue;
			
			dfs(depth+1, red.x, red.y, blue.x, blue.y);
		}
	}
	
	public static Result roll(int x, int y, int dir) {
		int dist = 0;
		while(true) {
			int newX = x + dx[dir];
			int newY = y + dy[dir];
			
			if(map[newX][newY] == '#') break;
			x = newX;
			y = newY;
			dist++;
			if(map[x][y] == 'O') return new Result(x, y, dist, true);
		}
		
		return new Result(x, y, dist, false);
	}
	
	public static class Result{
		int x, y, dist;
		boolean isHole;
		
		Result(int x, int y, int dist, boolean isHole){
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.isHole = isHole;
		}
	}
}
