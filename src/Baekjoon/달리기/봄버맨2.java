package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 봄버맨2 {
	
	static int R, C, N;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				char c = str.charAt(j);
				map[i][j] = c;
			}
		}
		
		if(N==1) {
			// 그냥 출력
			display(map);
		}else if(N % 2 == 0) {
			// 전체 폭탄
			fillFullBoom();
		}else if(N % 4 == 3) {
			// 첫 폭파
			char[][] firstBoom = boom(map);
			display(firstBoom);
		}else if(N % 4 == 1) {
			// 두번 폭파
			char[][] firstBoom = boom(map);
			char[][] secondBoom = boom(firstBoom);
			display(secondBoom);
		}
			

	}
	
	public static void display(char[][] map) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void fillFullBoom() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print("O");
			}
			System.out.println();
		}
	}
	
	public static char[][] boom(char[][] map){
		char[][] copy = new char[R][C];
		
		// 먼저 폭탄으로 채우기
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				copy[i][j] = 'O';
			}
		}
		
		// 폭탄 터트리기
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				
				if(map[i][j] == 'O') {
					copy[i][j] = '.';
					for(int d=0; d<4; d++) {
						int newX = i + dx[d];
						int newY = j + dy[d];
						
						if(newX < 0 || newY < 0 || newX >= R || newY >= C) continue;
						
						copy[newX][newY] = '.';
					}
				}
			}
		}
		
		return copy;
	}

}

