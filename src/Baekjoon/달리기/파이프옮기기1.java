package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 파이프옮기기1 {
	
	static int N, count;
	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		count = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 1, 0);
		System.out.println(count);
	}
	
	public static void DFS(int x, int y, int dir) {
		if(x == N-1 && y==N-1) {
			count++;
			return;
		}
		
		
		// 현재 가로일 떄
		if(dir==0) {
			// 가로 추가
			if(y+1 < N && map[x][y+1] == 0) {
				DFS(x, y+1, 0);
			}
		}
		// 현재 세로 일 때
		else if(dir==1){
			// 세로 추가
			if(x+1 < N && map[x+1][y] == 0) {
				DFS(x+1, y, 1);
			}
		}
		// 현재 대각선일 때
		else {
			// 가로 추가
			if(y+1 < N && map[x][y+1] == 0) {
				DFS(x, y+1, 0);
			}
			// 세로 추가
			if(x+1 < N && map[x+1][y] == 0) {
				DFS(x+1, y, 1);
			}
		}
		
		//대각선 추가
		if(x+1 < N && y+1 < N && map[x+1][y+1] == 0 && map[x][y+1] == 0 && map[x+1][y] == 0) {
			DFS(x+1, y+1, 2);
		}
	}

}
