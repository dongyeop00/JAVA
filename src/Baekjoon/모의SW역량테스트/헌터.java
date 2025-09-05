package Baekjoon.모의SW역량테스트;

import java.util.*;
import java.io.*;

public class 헌터 {

	static int N, maxNumber, min;
	static Monster[] monsters;
	static Client[] clients;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 최대 번호 구하기
			maxNumber = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					maxNumber = Math.max(maxNumber, Math.abs(map[i][j]));
				}
			}
			
			//몬스터, 고객 배열 할당
			monsters = new Monster[maxNumber+1];
			clients = new Client[maxNumber+1];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int num = map[i][j];
					if(num > 0) { // 몬스터
						monsters[num] = new Monster(num, i, j, false);
					}else if(num < 0) { // 고객
						int id = Math.abs(num);
						clients[id] = new Client(id, i, j, false);
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			dfs(0, 0, 0, 0);
			System.out.println("#" + testCase + " " + min);
		}
	}
	
	/**
	 * 
	 * @param currentX : 현재 x위치
	 * @param currentY : 현재 y위치
	 * @param done : 완료한 고객 수
	 * @param cost : 거리비용
	 */
	public static void dfs(int currentX, int currentY, int done, int cost) {
		// 가지치기
		if(cost >= min) return;
		
		// basis part
		if(done == maxNumber) {
			min = Math.min(min, cost);
			return;
		}
		
		// inductive part
		for(int i=1; i<=maxNumber; i++) {
			Monster m = monsters[i];
			if(m != null && !m.isKilled) {
				int distance = dist(currentX, currentY, m.x, m.y);
				m.isKilled = true;
				dfs(m.x, m.y, done, cost + distance);
				m.isKilled = false;
			}
		}
		
		for(int i=1; i<=maxNumber; i++) {
			Monster m = monsters[i];
			Client c = clients[i];
			if(m != null && c != null && m.isKilled && !c.isVisited) {
				int distance = dist(currentX, currentY, c.x, c.y);
				c.isVisited = true;
				dfs(c.x, c.y, done+1, cost + distance);
				c.isVisited = false;
			}
		}
	}
	
	private static int dist(int currentX, int currentY, int x, int y) {
		return Math.abs(currentX - x) + Math.abs(currentY - y);
	}

	public static class Monster{
		int id;
		int x;
		int y;
		boolean isKilled;
		
		public Monster(int id, int x, int y, boolean isKilled) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.isKilled = isKilled;
		}
		
		
	}
	
	public static class Client{
		int id;
		int x;
		int y;
		boolean isVisited;
		
		public Client(int id, int x, int y, boolean isVisited) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.isVisited = isVisited;
		}
	}

}
