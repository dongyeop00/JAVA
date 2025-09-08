package Baekjoon.Graph.BFS;

import java.util.*;
import java.io.*;

public class PuyoPuyo {
	
	static final int N = 12;
	static final int M = 6;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int count;
	static int boomCount;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[N][M];
		boomCount = 0;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
	
		while(true) {
			visited = new boolean[N][M];
			List<int[]> list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != '.' || visited[i][j]) {
						char current = map[i][j];
						List<int[]> boomList = BFS(i, j, current);
						
						if(boomList.size() >= 4) {
							list.addAll(boomList);
						}
					}
				}
			}
			
			if(list.isEmpty()) break;
			
			for(int[] area : list) map[area[0]][area[1]] = '.';
			boomCount++;
			gravity();
		}
		
		System.out.println(boomCount);
	}
	
	public static List<int[]> BFS(int x, int y, char current) {
		Queue<int[]> queue = new LinkedList<>();
		List<int[]> result = new LinkedList<>();
		
		queue.offer(new int[] {x, y});
		result.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] c = queue.poll();
			
			if(visited[c[0]][c[1]]) continue;
			visited[c[0]][c[1]] = true;
			
			for(int i=0; i<4; i++) {
				int newX = c[0] + dx[i];
				int newY = c[1] + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
				if(visited[newX][newY]) continue;
				if(map[newX][newY] == '.' || map[newX][newY] != current) continue;
				
				queue.offer(new int[] {newX, newY});
				result.add(new int[] {newX, newY});
			}
		}
		
		return result;
	}

	public static void gravity() {
		
		for(int k=0; k<M; k++) {
			for(int i=N-1; i>0; i--) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == '.') {
						map[i][j] = map[i-1][j];
						map[i-1][j] = '.';
					}
				}
			}
		}
	}
	
	public static void display() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
