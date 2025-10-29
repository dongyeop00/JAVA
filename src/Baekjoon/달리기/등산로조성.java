package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 등산로조성 {

	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	static List<Position> high;
	static int maxHigh, maxLength;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			maxHigh = 0;
			maxLength = 0;
			high = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHigh = Math.max(maxHigh, map[i][j]);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == maxHigh) {
						high.add(new Position(i, j));
					}
				}
			}
			
			for(Position p : high) {
				visited[p.x][p.y] = true;
				DFS(p.x, p.y, 1, false);
				visited[p.x][p.y] = false;
			}
			
			System.out.println("#" + testCase + " " + maxLength);
		}

	}
	
	public static void DFS(int x, int y, int length, boolean cut) {
		maxLength = Math.max(maxLength, length);
		
		for(int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
			if(visited[newX][newY]) continue;
			
			// 이동할 수 있으면
			if(map[x][y] > map[newX][newY]) {
				visited[newX][newY] = true;
				DFS(newX, newY, length+1, cut);
				visited[newX][newY] = false;
			// 이동할 수 없는데, K만큼 깎으면 이동할 수 있을 때 && 안깎았을 때
			}else if(map[x][y] > map[newX][newY] - K && !cut) {
				int originValue = map[newX][newY];
				map[newX][newY] = map[x][y] - 1;
				visited[newX][newY] = true;
				DFS(newX, newY, length+1, true);
				visited[newX][newY] = false;
				map[newX][newY] = originValue;
			}
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
