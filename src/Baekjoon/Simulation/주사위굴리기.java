package Baekjoon.Simulation;

import java.util.*;
import java.io.*;

public class 주사위굴리기 {

	static int N, M, x, y, K;
	static int[][] map;
	static int[] dice;
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dice = new int[7];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int newX = x + dx[dir];
			int newY = y + dy[dir];
			
			if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
			
			rollDice(dir);
			x = newX;
			y = newY;
			
			// 이동한 맵의 수가 0임
			if(map[x][y] == 0) {
				// 주사위 바닥면 값으로 변경
				map[x][y] = dice[6];
			}else { // 이동한 맵의 수가 0 아님
				// 맵의 값이 주사위 바닥면으로 변경
				dice[6] = map[x][y];
				map[x][y] = 0;
			}
			
			System.out.println(dice[1]);
		}
	}
	
	/*
	 * 		2
	 * 	4	1	3
	 * 		5
	 * 		6
	 */
	public static void rollDice(int dir) {
		int[] temp = dice.clone();
		if(dir == 1) { // 동
			dice[4] = temp[1];
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[6] = temp[4];
		}else if(dir == 2) { // 서
			dice[4] = temp[6];
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[6] = temp[3];
		}else if(dir == 3) { // 북
			dice[2] = temp[6];
			dice[1] = temp[2];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}else { // 남
			dice[6] = temp[2];
			dice[5] = temp[6];
			dice[1] = temp[5];
			dice[2] = temp[1];
		}
	}

}