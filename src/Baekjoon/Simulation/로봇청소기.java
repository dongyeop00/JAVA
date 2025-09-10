package Baekjoon.Simulation;

import java.util.*;
import java.io.*;

public class 로봇청소기 {
					//  상   우    하    좌 (0,1,2,3)
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean canMove = true;
		int cleanCount = 0;
		while(canMove) {
			
			// 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if(map[x][y] == 0) {
				map[x][y] = 2; // 2는 청소하는 경우
				cleanCount++;
			}
			
			// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			boolean needClean = false;
			for(int i=0; i<4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
				if(map[newX][newY] == 0) needClean = true;
			}
			
			// 2.1 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면
			if(!needClean) { // 
				int newX = x + dx[(dir+2)%4];
				int newY = y + dy[(dir+2)%4];
				
				// 경계 확인
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) break;
				if(map[newX][newY] == 1) break;
				
				x = newX;
				y = newY;
			}else { // 4칸 중 청소되지 않은 빈 칸이 있는 경우
				// 반시계 방향으로 90도 회전한다.
				dir = (dir+3) % 4;
				
				// 바라보는 방향을 기준으로 앞쪽 칸이 청소 되지 않은 빈 칸인 경우 한 칸 전진한다.
				int newX = x + dx[dir];
				int newY = y + dy[dir];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
				if(map[newX][newY] == 0) {
					x = newX;
					y = newY;
				}
			}
		}
		
		System.out.println(cleanCount);
	}

}
