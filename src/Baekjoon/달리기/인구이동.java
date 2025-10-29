package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 인구이동 {
	
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		boolean flag = false;
		
		while(true) {
			visited = new boolean[N][N];
			flag = false;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						if(BFS(i,j)) {
							flag = true;
						}
					}
				}
			}
			
			if(!flag) {
				break;
			}
			
			day++;
		}
		
		System.out.println(day);
	}
	
	public static boolean BFS(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		List<Position> union = new ArrayList<>();
		
		queue.offer(new Position(x, y));
		union.add(new Position(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			for(int i=0; i<4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
				if(visited[newX][newY]) continue;
				
				int sub = Math.abs(map[newX][newY] - map[current.x][current.y]);
				if(L <= sub && sub <= R) {
					queue.offer(new Position(newX, newY));
					union.add(new Position(newX, newY));
					visited[newX][newY] = true;
				}
			}
		}
		
		if(union.size() <= 1) {
			return false;
		}
		
		int avg = 0;
		for(Position p : union) {
			avg += map[p.x][p.y];
		}
		
		avg /= union.size();
		
		for(Position p : union) {
			map[p.x][p.y] = avg;
		}
		
		return true;
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
