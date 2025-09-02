package Baekjoon.Graph.Dijkstra;

import java.util.*;
import java.io.*;

public class 보급로 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			int result = dijkstra(N, map);
			System.out.println("#" + testCase + " " + result);
		}
	}
	
	public static int dijkstra(int N, int[][] map) {
		PriorityQueue<Position> queue = new PriorityQueue<>();
		int[][] dist = new int[N][N];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int INF = 1_000_000_000;
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		dist[0][0] = map[0][0];
		queue.offer(new Position(0, 0, dist[0][0]));
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			if(dist[current.x][current.y] < current.weight) continue;
			
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
		int x;
		int y;
		int weight;
		
		Position(int x, int y, int weight){
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

}
