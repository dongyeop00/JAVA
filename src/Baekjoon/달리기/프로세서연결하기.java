package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 프로세서연결하기 {
	
	static int N;
	static int[][] map;
	static List<Position> coreList;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int bestCore, bestLine;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			coreList = new ArrayList<>();
			bestCore = Integer.MIN_VALUE;
			bestLine = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != 0 && j != 0 && i != N-1 && j != N-1) {
						if(map[i][j] == 1) {
							coreList.add(new Position(i,j));
						}
					}
				}
			}
			
			DFS(0, 0, 0);
			System.out.println("#" + testCase + " " + bestLine);
		}
	}
	
	public static void DFS(int depth, int connectCore, int connectLine) {
		if(depth == coreList.size()) {
			if(connectCore > bestCore) {
				bestCore = connectCore;
				bestLine = connectLine;
			}else if(connectCore == bestCore && connectLine < bestLine) {
				bestLine = connectLine;
			}
			return;
		}
		
		Position current = coreList.get(depth);
		
		for(int i=0; i<4; i++) {
			int canConnectLength = testConnect(current, i);
			if(canConnectLength == 0) continue;
			
			connect(current, i);
			DFS(depth + 1, connectCore + 1, connectLine + canConnectLength);
			disConnect(current, i);
		}
		
		DFS(depth+1, connectCore, connectLine);
	}
	
	public static int testConnect(Position current, int dir) {
		int newX = current.x + dx[dir];
		int newY = current.y + dy[dir];
		int count = 0;
		
		while(0 <= newX && 0 <= newY && newX < N && newY < N) {
			
			if(map[newX][newY] != 0) return 0;
			
			count++;
			
			if(newX == 0 || newY == 0 || newX == N-1 || newY == N-1) return count;
			
			newX += dx[dir];
			newY += dy[dir];
		}
		
		return 0;
	}
	
	public static void connect(Position current, int dir) {
		int newX = current.x + dx[dir];
		int newY = current.y + dy[dir];
		
		while(0 <= newX && 0 <= newY && newX < N && newY < N) {
			
			map[newX][newY] = 2;
			
			
			newX += dx[dir];
			newY += dy[dir];
		}
	}
	
	public static void disConnect(Position current, int dir) {
		int newX = current.x + dx[dir];
		int newY = current.y + dy[dir];
		
		while(0 <= newX && 0 <= newY && newX < N && newY < N) {
			
			map[newX][newY] = 0;
			
			
			newX += dx[dir];
			newY += dy[dir];
		}
	}
	
	static class Position{
		int x;
		int y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
