package Baekjoon.Graph.BFS;

import java.util.*;
import java.io.*;

public class 인구이동 {
	
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*
		 * 인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.
		 * 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
		 * 위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
		 * 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
		 * 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
		 * 연합을 해체하고, 모든 국경선을 닫는다.
		 * 각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.
		 */
		
		boolean flag;
		int days = 0;
		
		while(true) {
			visited = new boolean[N][N];
			flag = false;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						if(BFS(i, j)) {
							flag = true;
						}
					}
				}
			}
			
			if(!flag) break;
			
			days++;
		}
		
		System.out.println(days);
	}
	
	public static boolean BFS(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		List<Position> list = new ArrayList<>();
		
		queue.offer(new Position(x, y));
		list.add(new Position(x, y));
		visited[x][y] = true;
		int sum = map[x][y];
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			for(int i=0; i<4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
				if(visited[newX][newY]) continue;
				
				// 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선 하루 연다.
				int diff = Math.abs(map[current.x][current.y] - map[newX][newY]);
				
				if(L <= diff && diff <= R) {
					visited[newX][newY] = true;
					queue.offer(new Position(newX, newY));
					list.add(new Position(newX, newY));
					sum += map[newX][newY];
				}
			}
		}
		
		if(list.size() <= 1) {
			return false;
		}

		int avg = sum / list.size();
		
		for(Position p : list) {
			map[p.x][p.y] = avg;
		}
		
		return true;
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
