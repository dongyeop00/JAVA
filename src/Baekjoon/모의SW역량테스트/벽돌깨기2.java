package Baekjoon.모의SW역량테스트;

import java.util.*;
import java.io.*;

public class 벽돌깨기2 {

	static int N, W, H, min;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			
			int[][] map = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			backTracking(map, 1);
			System.out.println("#" + testCase + " " + min);
		}
	}
	
	private static void backTracking(int[][] map, int count) {
		if(count > N) {
			min = Math.min(min, Count(map));
			return;
		}
		
		// 가로로 1개씩 공을 던짐
		for(int i=0; i<W; i++) {
			// 깊은복사
			int[][] copyMap = copyMap(map);
			
			// 공던지기
			shoot(copyMap, i);
			
			// 내리기
			merge(copyMap);
			
			// 다음공
			backTracking(copyMap, count+1);
		}
	}
	
	private static void shoot(int[][] copyMap, int i) {
		Queue<Position> queue = new LinkedList<>();
		
		// 세로 기준 맨 위에 있는 공을 선택
		for(int k=0; k<H; k++) {
			if(copyMap[k][i] != 0) {
				queue.offer(new Position(k, i, copyMap[k][i]));
				break;
			}
		}
		
		while(!queue.isEmpty()) {
			//공을 꺼냄
			Position current = queue.poll();
			
			//해당 맵 폭발 처리
			copyMap[current.x][current.y] = 0;
			
			//크기 만큼 사방탐색
			for(int p=0; p<current.power; p++) {
				for(int d=0; d<4; d++) {
					int newX = current.x + dx[d] * p;
					int newY = current.y + dy[d] * p;
					
					if(newX < 0 || newY < 0 || newX >= H || newY >= W) continue;
					if(copyMap[newX][newY] == 0) continue;
					
					queue.offer(new Position(newX, newY, copyMap[newX][newY]));
				}
			}
		}
	}
	
	private static void merge(int[][] copyMap) {
		for(int cnt=0; cnt<H; cnt++) {
			for(int i=H-1; i>0; i--) {
				for(int j=0; j<W; j++) {
					if(copyMap[i][j] == 0) {
						copyMap[i][j] = copyMap[i-1][j];
						copyMap[i-1][j] = 0;
					}
				}
			}
		}
	}
	
	private static int Count(int[][] copyMap) {
		int count = 0;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(copyMap[i][j] != 0) count++;
			}
		}
		
		return count;
	}
	
	private static int[][] copyMap(int[][] map){
		int[][] copy = new int[H][W];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		return copy;
	}
	
	private static class Position{
		int x;
		int y;
		int power;
		
		Position(int x, int y, int power){
			this.x = x;
			this.y = y;
			this.power = power;
		}
	}
}
