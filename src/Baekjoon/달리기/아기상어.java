package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 아기상어 {
	
	static int N;
	static int[][] map;
	static int sx, sy;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		}
		
		/*
		 * 	1. 초기 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.

			2. if (아기 상어 크기 ≥ 물고기 크기) 아기 상어가 지나갈 수 있다.

			3. if (아기 상어 크기 > 물고기 크기) 아기 상어가 물고기를 먹을 수 있다.

			4. 먹을 수 있는 물고기가 1마리라면 그 물고기를 먹으러 가고,
		
			5. 먹을 수 있는 물고기가 1마리보다 많으면, 거리가 가장 가까운 물고기를 먹으러 간다.

    			거리가 가까운 물고기가 많으면, 가장 위에 있는 물고기, 그러한 물고기가 여러 마리라면, 가장 왼쪽에 있는 물고기를 먹는다.

			6. 자신의 크기와 같은 수의 물고기를 먹을 때 마다 아기 상어의 크기가 1 증가한다 
		 */

		int time = 0;
		int size = 2;
		int eat = 0;
		
		while(true) {
			// 1. 현재 위치에서 최단거리 먹잇감 탐색
			Fish fish = BFS(size);
			
			// 2. 먹잇감이 없으면 종료
			if(fish == null) {
				break;
			}
			
			// 3. 해당 위치로 이동
			time += fish.dist;
			sx = fish.x;
			sy = fish.y;
			map[sx][sy] = 0;
			eat++;
			
			// 4. 사이즈 업
			if(size == eat) {
				size++;
				eat = 0;
			}
			
		}
		
		System.out.println(time);
		
	}
	
	public static Fish BFS(int size) {
		Queue<Shark> queue = new LinkedList<>();
		PriorityQueue<Fish> prqueue = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		int[][] dist = new int[N][N];
		int mindist = Integer.MAX_VALUE;
		
		queue.offer(new Shark(sx, sy));
		visited[sx][sy] = true;
		
		while(!queue.isEmpty()) {
			Shark current = queue.poll();
			
			if(dist[current.x][current.y] > mindist) continue;
			
			for(int d=0; d<4; d++) {
				int newX = current.x + dx[d];
				int newY = current.y + dy[d];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
				if(visited[newX][newY]) continue;
				
				// 이동 가능한 곳인지?
				if(map[newX][newY] <= size) {
					visited[newX][newY] = true;
					dist[newX][newY] = dist[current.x][current.y] + 1;
					
					// 먹을 수 있는가?
					if(map[newX][newY] != 0 && map[newX][newY] < size) {
						prqueue.offer(new Fish(newX, newY, dist[newX][newY]));
						mindist = dist[newX][newY];
					}else {
						queue.offer(new Shark(newX, newY));
					}
				}
			}
		}
		
		return prqueue.isEmpty() ? null : prqueue.poll();
	}

	
	public static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int dist;
		
		Fish(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			// 우선순위 조건
			
			// 1. 가장 가까운 거리
			int result = Integer.compare(this.dist, o.dist);
			if(result != 0 ) return result;
			
			// 2. 가장 위쪽에 있는 물고기
			result = Integer.compare(this.x, o.x);
			if(result != 0) return result;
			
			// 3. 가장 왼쪽에 있는 물고기
			return Integer.compare(this.y, o.y);
		}
	}
	
	
	public static class Shark{
		int x;
		int y;
		
		Shark(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
