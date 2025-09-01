package Baekjoon.Graph.BFS;

import java.util.*;
import java.io.*;

public class 달리기 {
	
	static int N, M, K;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int sx, sy, ex, ey;

	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.---------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				char temp = str.charAt(j);
				if(temp == '.') map[i][j] = 0; // 길
				else map[i][j] = 1; // 벽
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;
		
		int result = BFS();
		System.out.println(result);
	}
	
	public static int BFS() {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(sx, sy));
		visited[sx][sy] = 0;
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			if(current.x == ex && current.y == ey) {
				return visited[current.x][current.y];
			}
			
			// 한 방향으로만 간다.
			for(int d=0; d<4; d++) {
				for(int count=1; count<=K; count++) {
					int newX = current.x + dx[d] * count;
					int newY = current.y + dy[d] * count;
					
					if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
					if(map[newX][newY] == 1) break;
					
					// 처음 갈 때
					if(visited[newX][newY] == 0) {
						visited[newX][newY] = visited[current.x][current.y] + 1;
						queue.offer(new Position(newX, newY));
					}else if(visited[newX][newY] <= visited[current.x][current.y]){
						break;
					}
				}
			}
		}
		
		return -1;
	}
	
	public static class Position{
		int x;
		int y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}

