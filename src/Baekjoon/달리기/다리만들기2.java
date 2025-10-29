package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 다리만들기2 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static List<Edge> edgeList;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		edgeList = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 섬 넘버링
		int number = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					setNumber(i, j, number++);
				}
			}
		}
		
		// 2. 간선 정보 얻기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					getEdgeList(i, j, map[i][j]);
				}
			}
		}
		
		// 3. mst
		int result = Prim(number);
		System.out.println(result);
	}
	
	public static void setNumber(int x, int y, int number) {
		Queue<Position> queue = new LinkedList<>();
		
		queue.offer(new Position(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			map[current.x][current.y] = number;
			
			for(int i=0; i<4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
				if(visited[newX][newY]) continue;
				if(map[newX][newY] == 0) continue;
				
				queue.offer(new Position(newX, newY));
				visited[newX][newY] = true;
			}
		}
	}
	
	public static void getEdgeList(int x, int y, int number) {
		Queue<Position> queue = new LinkedList<>();
		
		for(int i=0; i<4; i++) {
			queue.offer(new Position(x, y, 0));
			
			while(!queue.isEmpty()) {
				Position current = queue.poll();
				
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
				
				if(map[newX][newY] != number) {
					if(map[newX][newY] != 0) {
						int from = number;
						int to = map[newX][newY];
						int weight = current.dist;
						if(weight > 1) {
							edgeList.add(new Edge(from, to, weight));
						}
					}else {
						queue.offer(new Position(newX, newY, current.dist+1));
					}
				}
			}
		}
	}
	
	public static int Prim(int number) {
		List<List<Edge>> graph = new ArrayList<>();
		boolean[] visited = new boolean[number];
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		
		for(int i=0; i<=number; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(Edge e : edgeList) {
			graph.get(e.from).add(new Edge(e.to, e.weight));
			graph.get(e.to).add(new Edge(e.from, e.weight));
		}
		
		visited[1] = true;
		for(Edge e : graph.get(1)) {
			queue.offer(e);
		}
		
		int total = 0;
		int pick = 0;
		
		while(!queue.isEmpty() && pick < number - 1) {
			Edge current = queue.poll();
			
			if(visited[current.to]) continue;
			
			visited[current.to] = true;
			total += current.weight;
			pick++;
			
			for(Edge e : graph.get(current.to)) {
				queue.offer(e);
			}
		}
		
		for(int i=1; i<number; i++) {
			if(!visited[i]) return -1;
		}
		
		return total;
	}
	
	public static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static class Position {
		int x;
		int y;
		int dist;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		Position(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

}
