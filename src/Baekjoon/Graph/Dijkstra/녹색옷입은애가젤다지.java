package Baekjoon.Graph.Dijkstra;

import java.util.*;
import java.io.*;

public class 녹색옷입은애가젤다지 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = 1;
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = dijkstra(N, map);
			System.out.println("Problem " + testCase++ + ": " + result);
		}
	}
	
	public static int dijkstra(int N, int[][] map) {
		PriorityQueue<Position> queue = new PriorityQueue<>();
		int INF = 1_000_000_000;
		int[][] dist = new int[N][N];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		dist[0][0] = map[0][0];
		queue.offer(new Position(0, 0, dist[0][0]));
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			// 이미 더 짧은 거리로 방문한 적이 있다면
			if(dist[current.x][current.y] < current.lost) continue;
			
			for(int i=0; i<4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
				
				int newCost = dist[current.x][current.y] + map[newX][newY];
				
				if(dist[newX][newY] > newCost) {
					dist[newX][newY] = newCost;
					queue.offer(new Position(newX, newY, newCost));
				}
			}
		}
		
		return dist[N-1][N-1];
	}
	
	public static class Position implements Comparable<Position>{
		int x, y, lost;
		
		Position(int x, int y, int lost){
			this.x = x;
			this.y = y;
			this.lost = lost;
		}

		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.lost, o.lost);
		}
	}

}
