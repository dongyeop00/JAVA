package Baekjoon.Graph.BFS;

import java.util.*;
import java.io.*;

public class 치즈2 {

	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		
		while(true) {
			visited = new boolean[N][M];
			
			// 내부 / 외부 나누기
			DFS(0, 0);
			
			// 2칸 이상 접촉 리스트 구하기
			List<Position> list = getCheese();
			
			if(list.size() == 0) break;
			
			meltCheese(list);
			
			time++;
		}

		System.out.println(time);
	}
	
	public static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
			if(visited[newX][newY]) continue;
			if(map[newX][newY] != 0) continue;
			
			DFS(newX, newY);
		}
	}
	
	public static List<Position> getCheese(){
		List<Position> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				// 방문하지 않았거나(내부,치즈) && 치즈인곳
				if(!visited[i][j] && map[i][j] == 1) {
					
					int count = 0;
					for(int d=0; d<4; d++) {
						int newX = i + dx[d];
						int newY = j + dy[d];
						
						if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
						if(map[newX][newY] == 0 && visited[newX][newY]) {
							count++;
						}
					}
					
					if(count >= 2) {
						list.add(new Position(i, j));
					}
				}
			}
		}
		
		return list;
	}
	
	public static void meltCheese(List<Position> list) {
		for(Position p : list) {
			map[p.x][p.y] = 0;
		}
	}
	
	public static class Position{
		int x;
		int y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void displayVisited() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void displayMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
