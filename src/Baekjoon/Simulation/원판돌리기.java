package Baekjoon.Simulation;

import java.util.*;
import java.io.*;

public class 원판돌리기 {
	
	static int N, M, T;
	static int[][] disk;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean canErase;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		canErase = true;
		
		// 배수 판단을 위해 인덱스 1부터 시작
		disk = new int[N+1][M];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				disk[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Spin(X, D, K);
			Erase();
		}
		
		// 지울 수 있다면
		System.out.println(result());
	}

	/**
	 * 
	 * @param x : x의 배수의 원판을 돌린다.
	 * @param d : 0인 경우 시계 방향, 1인 경우 반시계 방향
	 * @param k : k칸 회전시킨다.
	 */
	public static void Spin(int x, int d, int k) {
		for(int i=x; i<N+1; i+=x) {
			if(d == 0) { //시계 방향, k칸 만큼 회전
				for(int spin=0; spin<k; spin++) {
					int temp = disk[i][M-1];
					for(int j=M-1; j>0; j--) {
						disk[i][j] = disk[i][j-1];
					}
					disk[i][0] = temp;
				}
			}else { // 반시계 방향, k칸 만큼 회전
				for(int spin=0; spin<k; spin++) {
					int temp = disk[i][0];
					for(int j=0; j<M-1; j++) {
						disk[i][j] = disk[i][j+1];
					}
					disk[i][M-1] = temp;
				}
			}
		}
	}
	
	public static void Erase() {
		// 1. 이번턴에 지울 수 있는 구역 설정 한 뒤 일괄 삭제
		boolean[][] mark = new boolean[N+1][M];
		boolean erase = false;
		
		for(int i=1; i<N+1; i++) {
			for(int j=0; j<M; j++) {
				
				int value = disk[i][j];
				if(value == 0) continue;
				
				// 상하 인접
				if(i-1 >= 1 && value == disk[i-1][j]) {
					mark[i][j] = true;
					mark[i-1][j] = true;
				}
				if(i+1 < N+1 && value == disk[i+1][j]) {
					mark[i][j] = true;
					mark[i+1][j] = true;
				}
				
				// 좌우 인접
				int left = (j - 1 + M) % M;
				int right = (j + 1) % M;
				if(value == disk[i][left]) {
					mark[i][j] = true;
					mark[i][left] = true;
				}
				if(value == disk[i][right]) {
					mark[i][j] = true;
					mark[i][right] = true;
				}
			}
		}
		
		// 2. 일괄 삭제
		for(int i=1; i<N+1; i++) {
			for(int j=0; j<M; j++) {
				if(mark[i][j]) {
					disk[i][j] = 0;
					erase = true;
				}
			}
		}
		
		canErase = erase;
		
		// 3. 지운게 없으면 평균에 +- 1 해주기
		if(!canErase) {
			int sum = 0;
			int count = 0;
			
			for(int i=1; i<N+1; i++) {
				for(int j=0; j<M; j++) {
					if(disk[i][j] != 0) {
						sum += disk[i][j];
						count++;
					}
				}
			}
			
			if(count == 0) return;
			
			double average = (double) sum / count;
			
			for(int i=1; i<N+1; i++) {
				for(int j=0; j<M; j++) {
					if(disk[i][j] != 0) {
						if(disk[i][j] < average) {
							disk[i][j]++;
						}else if(disk[i][j] > average) {
							disk[i][j]--;
						}
					}
				}
			}
		}
	}
	
	public static int result() {
		int sum = 0;
		
		for(int i=1; i<N+1; i++) {
			for(int j=0; j<M; j++) {
				if(disk[i][j] != 0) {
					sum += disk[i][j];
				}
			}
		}
		
		return sum;
	}
	
	public static void display() {
		for(int i=1; i<N+1; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(disk[i][j]);
			}
			System.out.println();
		}
	}
}
