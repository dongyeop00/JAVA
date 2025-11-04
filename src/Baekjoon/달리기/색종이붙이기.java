package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 색종이붙이기 {
	
	static int N = 10;
	static int[][] map;
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int minPaper = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backTracking(0);
		System.out.println(minPaper == Integer.MAX_VALUE ? -1 : minPaper);
	}
	
	public static void backTracking(int useCount) {
		int sx = -1;
		int sy = -1;
		
		// 1. 색종이 붙일 좌표를 찾는다.
		L:for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					sx = i;
					sy = j;
					break L;
				}
			}
		}
		
		// 2. 붙일 좌표가 없다면 종료 
		if(sx == -1 && sy == -1) {
			minPaper = Math.min(minPaper, useCount);
			return;
		}
		
		// 3. 좌표에서 붙일 수 있는 최대 사이즈 구하기
		int size = getMaxSize(sx, sy);
		
		// 4. 최대 사이즈부터 줄여 나가며 붙이기
		while(size > 0) {
			if(paper[size] > 0) {
				
				paper[size]--;
				for(int i=sx; i<sx+size; i++) {
					for(int j=sy; j<sy+size; j++) {
						map[i][j] = 0;
					}
				}
				
				backTracking(useCount+1);
				
				paper[size]++;
				for(int i=sx; i<sx+size; i++) {
					for(int j=sy; j<sy+size; j++) {
						map[i][j] = 1;
					}
				}	
			}
			size--;
		}
	}
	
	public static int getMaxSize(int sx, int sy) {
		int size = 5;
		while(size > 0) {
			boolean ok = true;
			L:for(int i=sx; i<sx+size; i++) {
				for(int j=sy; j<sy+size; j++) {
					
					// 범위 밖에 있으며
					if(i < 0 || j < 0 || i >= N || j >= N || map[i][j] == 0) {
						ok = false;
						break L;
					}
				}
			}
			
			if(ok) {
				return size;
			}
			size--;
		}
		
		return 0;
	}
	
}
