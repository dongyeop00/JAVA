package Baekjoon.Graph.BFS;

import java.util.*;
import java.io.*;

public class 오나의여신님 {
	
	static int N, M;
	static char[][] map;
	static int ex, ey;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			Queue<Position> human = new LinkedList<>();
			Queue<Position> devil = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'S') {
						human.offer(new Position(i, j, 0));
					}
					else if(map[i][j] == 'D') {
						ex = i;
						ey = j;
					}
					else if(map[i][j] == '*') {
						devil.offer(new Position(i,j));
					}
				}
			}
			
			int result = BFS(human, devil);
			System.out.println("#" + testCase + " " + (result == 0 ? "GAME OVER" : result));
		}
	}
	
	private static int BFS(Queue<Position> human, Queue<Position> devil) {
		boolean[][] visited = new boolean[N][M];
		
		while(!human.isEmpty()) {
			
			int devilSize = devil.size();
			for(int i=0; i<devilSize; i++) {
				Position current = devil.poll();
				
				for(int d=0; d<4; d++) {
					int newX = current.x + dx[d];
					int newY = current.y + dy[d];
					
					if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
					if(map[newX][newY] == 'D') continue;
					if(map[newX][newY] == 'X') continue;
					if(map[newX][newY] == '*') continue;
					
					map[newX][newY] = '*';
					devil.offer(new Position(newX, newY));
				}
			}
			
			int humanSize = human.size();
			for(int i=0; i<humanSize; i++) {
				Position current = human.poll();
				
				if(current.x == ex && current.y == ey) return current.dist;
				
				for(int d=0; d<4; d++) {
					int newX = current.x + dx[d];
					int newY = current.y + dy[d];
					
					if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
					if(map[newX][newY] == '*') continue;
					if(map[newX][newY] == 'X') continue;
					if(visited[newX][newY]) continue;
					
					visited[newX][newY] = true;
					human.offer(new Position(newX, newY, current.dist+1));
				}
			}
		}

		return 0;
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
