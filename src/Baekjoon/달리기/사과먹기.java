package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 사과먹기 {
	
	static int N, maxApple, minSpin;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			maxApple = Integer.MIN_VALUE;
			minSpin = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxApple = Math.max(maxApple, map[i][j]);
				}
			}
			
			DFS(0, 0, 0, 0, 1);
			System.out.println("#" + testCase + " " + minSpin);
		}
	}
	
	public static void DFS(int x, int y, int dir, int spin, int apple) {
		
		if(apple-1 == maxApple) {
			minSpin = Math.min(minSpin, spin);
			return;
		}
		
		if(map[x][y] == apple) {
			apple += 1;
		}
		
		int newX = x + dx[dir];
		int newY = y + dy[dir];
		
		if(right(x, y, dir, apple) || (newX < 0 || newY < 0 || newX >= N || newY >= N)) {
			int newDir = (dir+1)%4; //오른쪽 회전
			DFS(x, y, newDir, spin+1, apple); // 회전한 채로 재귀 수행
			return;
		}
		
		DFS(newX, newY, dir, spin, apple); // 그냥 전진
		
	}
	
	public static boolean right(int x, int y, int dir, int apple) {
		int newDir = (dir+1)%4; //오른쪽 한 채로
		// 배열 범위 안에 있을 떄까지 반복
		while(x >= 0 && y >= 0 && x < N && y < N) {
			x += dx[newDir];
			y += dy[newDir];
			
            if(x >= 0 && y >= 0 && x < N && y < N){
                if(map[x][y] == apple) return true;
            }
		}
		
		return false;
	}

}
