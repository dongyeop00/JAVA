package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 헌터 {
	
	static int N, maxNum, minTime;
	static int[][] map;
	static Client[] clients;
	static Monster[] monsters;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			maxNum = Integer.MIN_VALUE;
			minTime = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxNum = Math.max(maxNum, map[i][j]);
				}
			}
			
			clients = new Client[maxNum+1];
			monsters = new Monster[maxNum+1];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int temp = map[i][j];
					if(temp > 0) {
						monsters[temp] = new Monster(temp, i, j, false);
					}else {
						int id = Math.abs(temp);
						clients[id] = new Client(id, i, j, false);
					}
				}
			}
			
			
			DFS(0, 0, 0, 0);
			System.out.println("#" + testCase + " " + minTime);
		}
	}
	
	public static void DFS(int x, int y, int count, int time) {
		if(time >= minTime) {
			return;
		}
		
		if(count == maxNum) {
			minTime = Math.min(minTime, time);
			return;
		}
		
		for(int i=1; i<=maxNum; i++) {
			Monster m = monsters[i];
			if(!m.isKilled) {
				int getTime = getTime(x, y, m.x, m.y);
				m.isKilled = true;
				DFS(m.x, m.y, count, time + getTime);
				m.isKilled = false;
			}
		}
		
		for(int i=1; i<=maxNum; i++) {
			Monster m = monsters[i];
			Client c = clients[i];
			if(m.isKilled && !c.isVisited) {
				int getTime = getTime(x, y, c.x, c.y);
				c.isVisited = true;
				DFS(c.x, c.y, count+1, time + getTime);
				c.isVisited = false;
			}
		}
	}
	
	public static int getTime(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	public static class Client{
		int id;
		int x;
		int y;
		boolean isVisited;
		
		Client(int id, int x, int y, boolean isVisited){
			this.id = id;
			this.x = x;
			this.y = y;
			this.isVisited = isVisited;
		}
	}
	
	public static class Monster{
		int id;
		int x;
		int y;
		boolean isKilled;
		
		Monster(int id, int x, int y, boolean isKilled){
			this.id = id;
			this.x = x;
			this.y = y;
			this.isKilled = isKilled;
		}
	}

}
