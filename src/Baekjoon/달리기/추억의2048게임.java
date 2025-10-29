package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 추억의2048게임 {
	
	static int N;
	static String S;
	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			S = st.nextToken();
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			moveMap();
			System.out.println("#" + testCase);
			display();
		}
	}
	
	public static void up() {
		for(int i=0; i<N; i++) {
			boolean[] isSum = new boolean[N];
			
			for(int j=0; j<N-1; j++) {
				if(map[j][i] == 0 ) continue;
				
				for(int k=j+1; k<N; k++) {
					if(map[k][i] == 0) continue;
					else if(map[j][i] == map[k][i] && !isSum[j]) {
						map[j][i] *= 2;
						map[k][i] = 0;
						isSum[j] = true;
					}
					break;
				}
			}
			
			// 밀착
			int[] sort = new int[N];
			int index = 0;
			for(int j=0; j<N; j++) {
				if(map[j][i] != 0) {
					sort[index++] = map[j][i];
				}
			}
			
			for(int j=0; j<N; j++) {
				map[j][i] = sort[j];
			}
		}
	}
	
	public static void down() {
		for(int i=0; i<N; i++) {
			boolean[] isSum = new boolean[N];
			
			for(int j=N-1; j>0; j--) {
				if(map[j][i] == 0) continue;
				
				for(int k=j-1; k>=0; k--) {
					if(map[k][i] == 0) continue;
					else if(map[j][i] == map[k][i] && !isSum[j]) {
						map[j][i] *= 2;
						map[k][i] = 0;
						isSum[j] = true;
					}
					break;
				}
			}
			
			int[] sort = new int[N];
			int index = N-1;
			for(int j=N-1; j>=0; j--) {
				if(map[j][i] != 0) {
					sort[index--] = map[j][i];
				}
			}
			
			for(int j=N-1; j>=0; j--) {
				map[j][i] = sort[j];
			}
		}
	}
	
	public static void right() {
		for(int i=0; i<N; i++) {
			boolean[] isSum = new boolean[N];
			
			for(int j=N-1; j>0; j--) {
				if(map[i][j] == 0) continue;
				
				for(int k=j-1; k>=0; k--) {
					if(map[i][k] == 0) continue;
					else if(map[i][j] == map[i][k] && !isSum[j]) {
						map[i][j] *= 2;
						map[i][k] = 0;
						isSum[j] = true;
					}
					break;
				}
			}
			
			int[] sort = new int[N];
			int index = N-1;
			for(int j=N-1; j>=0; j--) {
				if(map[i][j] != 0) {
					sort[index--] = map[i][j];
				}
			}
			
			for(int j=N-1; j>=0; j--) {
				map[i][j] = sort[j];
			}
		}
	}
	
	public static void left() {
		for(int i=0; i<N; i++) {
			boolean[] isSum = new boolean[N];
			
			for(int j=0; j<N-1; j++) {
				if(map[i][j] == 0) continue;
				
				for(int k=j+1; k<N; k++) {
					if(map[i][k] == 0) continue;
					else if(map[i][j] == map[i][k] && !isSum[j]) {
						map[i][j] *= 2;
						map[i][k] = 0;
						isSum[j] = true;
					}
					break;
				}
			}
			
			int[] sort = new int[N];
			int index = 0;
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0) {
					sort[index++] = map[i][j];
				}
			}
			
			for(int j=0; j<N; j++) {
				map[i][j] = sort[j];
			}
		}
	}
	
	public static void moveMap() {
		if(S.equals("up")) {
			up();
		}else if(S.equals("down")) {
			down();
		}else if(S.equals("right")) {
			right();
		}else {
			left();
		}
	}
	
	public static void display() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
