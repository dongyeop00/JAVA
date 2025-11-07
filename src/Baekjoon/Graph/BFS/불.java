package Baekjoon.Graph.BFS;

import java.util.*;
import java.io.*;

public class 불 {
	
	static int N, M, minTime;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Position> jihoon = new LinkedList<>();
	static Queue<Position> fire = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		minTime = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') {
					jihoon.offer(new Position(i, j, 0));
				}else if(map[i][j] == 'F') {
					fire.offer(new Position(i, j));
				}
			}
		}
		
		while(!jihoon.isEmpty()) {
			int fireSize = fire.size();
			int jihoonSize = jihoon.size();
			
			for(int i=0; i<fireSize; i++) {
				Position current = fire.poll();
				
				for(int d=0; d<4; d++) {
					int newX = current.x + dx[d];
					int newY = current.y + dy[d];
					
					if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
					if(map[newX][newY] == '#') continue;
					if(map[newX][newY] == 'J') continue;
					if(map[newX][newY] == 'F') continue;
					
					map[newX][newY] = 'F';
					fire.offer(new Position(newX, newY));
				}
			}
			
			for(int i=0; i<jihoonSize; i++) {
				Position current = jihoon.poll();
				
				for(int d=0; d<4; d++) {
					int newX = current.x + dx[d];
					int newY = current.y + dy[d];
					
					if(newX < 0 || newY < 0 || newX >= N || newY >= M) {
						minTime = Math.min(minTime, current.dist+1);
						continue;
					}
					
					if(map[newX][newY] == '#') continue;
					if(map[newX][newY] == 'F') continue;
					if(visited[newX][newY]) continue;
				
					visited[newX][newY] = true;
					map[newX][newY] = 'J';
					map[current.x][current.y] = '.';
					jihoon.offer(new Position(newX, newY, current.dist+1));
				}
			}
		}
		
		System.out.println(minTime == Integer.MAX_VALUE ? "IMPOSSIBLE" : minTime);
	}
	
	static class Position{
		int x;
		int y;
		int dist;
		
		Position(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
