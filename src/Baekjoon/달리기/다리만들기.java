package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 다리만들기 {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int minLength;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		minLength = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 번호 붙이기
		int number = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					numbering(i, j, number++);
				}
			}
		}
		
		// 가장 자리에서 다른 섬으로 잇기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 현재 좌표에서 4방 탐색하여 가장자리에서만 bfs 수행하기
				if(map[i][j] != 0) {
					for(int d=0; d<4; d++) {
						int newX = i + dx[d];
						int newY = j + dy[d];
						
						if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
						if(map[newX][newY] != 0) continue;
						
						// 4방 탐색 했는데 가장리라면? 다리 잇기 수행
						connect(i, j, map[i][j]);
						break;
					}
				}
			}
		}
		
		System.out.println(minLength-1);
	}
	
	// 섬 번호 생성하기
	public static void numbering(int x, int y, int number) {
		Queue<Position> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.offer(new Position(x,y));
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			map[current.x][current.y] = number;
			
			for(int d=0; d<4; d++) {
				int newX = current.x + dx[d];
				int newY = current.y + dy[d];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
				if(visited[newX][newY]) continue;
				if(map[newX][newY] == 0) continue;
				
				queue.offer(new Position(newX, newY));
				visited[newX][newY] = true;
			}
			
		}
	}
	
	// 다리 잇기
	public static void connect(int x, int y, int number) {
		Queue<Position> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		queue.offer(new Position(x, y, 0));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			// 현재 위치가 출발한 곳과 다른 번호이거나 바다가 아니여야함
			if(map[current.x][current.y] != number && map[current.x][current.y] != 0) {
				minLength = Math.min(minLength, current.distance);
				return;
			}
			
			 for(int i=0; i<4; i++) {
				 int newX = current.x + dx[i];
				 int newY = current.y + dy[i];
				 
				 if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
				 if(visited[newX][newY]) continue;
				 if(map[newX][newY] == number) continue;
				 
				 queue.offer(new Position(newX, newY, current.distance+1));
				 visited[newX][newY] = true;
			 }
		}
	}

	
	static class Position{
		int x;
		int y;
		int distance;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		Position(int x, int y, int distance){
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

}
