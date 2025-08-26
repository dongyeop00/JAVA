package Baekjoon.Graph.MST.Prim;

import java.util.*;
import java.io.*;

public class 다리만들기2 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<Edge> list;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 구역 나누기
		int num = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					splitIsland(i,j,num);
					num++;
				}
			}
		}
		
		// 섬끼리의 최단거리 구하기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					getShortDist(i, j, map[i][j]);
				}
			}
		}
		
		// mst 구하기 (Prim)
		int result = Prim(num);
		System.out.println(result);
		 
	}
	
	// 섬 구역 나누기
	private static void splitIsland(int x, int y, int num) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			map[current[0]][current[1]] = num;
			
			for(int i=0; i<4; i++) {
				int newX = current[0] + dx[i];
				int newY = current[1] + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
				if(visited[newX][newY]) continue;
				if(map[newX][newY] == 0) continue;
				
				visited[newX][newY] = true;
				queue.offer(new int[] {newX, newY});
			}
		}
	}
	
	private static void getShortDist(int x, int y, int num) {
		Queue<Position> queue = new LinkedList<>();
		visited = new boolean[N][M];
		
		
		for(int i=0; i<4; i++) {
			queue.offer(new Position(x, y, 0));
			visited[x][y] = true;
			
			while(!queue.isEmpty()) {
				Position current = queue.poll();
				
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
				if(visited[newX][newY]) continue;
				
				if(map[newX][newY] != num) {
					if(map[newX][newY] != 0) {
						int from = num;
						int to = map[newX][newY];
						int weight = current.dist;
						if(weight > 1) {
							list.add(new Edge(from, to, weight));
						}
					}else {
						queue.add(new Position(newX, newY, current.dist+1));
						visited[newX][newY] = true;
					}
				}
			}
		}
	}
	
	private static int Prim(int count) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] island = new boolean[count];
		List<List<Edge>> graph= new ArrayList<>();
		
		for(int i=0; i<=count; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(Edge e : list) {
			graph.get(e.from).add(new Edge(e.to, e.weight));
			graph.get(e.to).add(new Edge(e.from, e.weight));
		}
		
		// 1번부터 시작
		island[1] = true;
		for(Edge e : graph.get(1)) {
			queue.add(e);
		}
		
		int total = 0;
		int pick = 0;
		
		while(!queue.isEmpty() && pick < count -1) {
			Edge current = queue.poll();
			
			if(island[current.to]) continue;
			
			island[current.to] = true;
			total += current.weight;
			pick++;
			
			for(Edge e : graph.get(current.to)) {
				queue.offer(e);
			}
		}
		
		for(int i=1; i<count; i++) {
			if(!island[i]) return -1;
		}
		
		return total;
	}
	
	private static class Edge implements Comparable<Edge>{
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
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
	}
	
	private static class Position{
		int x, y, dist;
		
		Position(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	private static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
