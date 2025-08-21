package Baekjoon.모의SW역량테스트;
import java.io.*;
import java.util.*;

public class 벽돌깨기 {
	
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
			
			solve(map, 1);
			System.out.println("#" + testCase + " " + min);
		}
	}
	
	/**
	 * 
	 * @param map : 현재 상태 map (copy를 계속함)
	 * @param count : 공 던진 회수
	 */
	
	public static void solve(int[][] map, int count) {
		if(count > N) {
			min = Math.min(min, remain(map));
			return;
		}
		
		// 가로마다 1칸씩 공 던지기
		for(int i=0; i<W; i++) {
			// 맵 복사
			int copyMap[][] = copy(map);
			
			// 공 던지기
			shoot(copyMap, i);

			// 공 내리기
			gravity(copyMap);
			
			// 다음 공
			solve(copyMap, count+1);
		}
	}
	
	public static void shoot(int[][] copyMap, int r) {
		Queue<Position> queue = new LinkedList<>();
		
		for(int i=0; i<H; i++) {
			if(copyMap[i][r] != 0) {
				queue.offer(new Position(i, r, copyMap[i][r]));
				break;
			}
		}
		
		while(!queue.isEmpty()) {
			Position p = queue.poll();
			int currentX = p.x;
			int currentY = p.y;
			int currentPower = p.power;
			
			if(copyMap[currentX][currentY] == 0) continue;
			
			copyMap[currentX][currentY] = 0;
			
			for(int i=0; i<currentPower; i++) {
				for(int j=0; j<4; j++) {
					int newX = currentX + dx[j]*i;
					int newY = currentY + dy[j]*i;
					
					if(newX >= 0 && newY >= 0 && newX < H && newY < W) {
						if(copyMap[newX][newY] != 0) {
							queue.offer(new Position(newX, newY, copyMap[newX][newY]));
						}
					}
				}
			}
		}
	}
	
	public static void gravity(int[][] map) {
		for(int cnt=0; cnt<H; cnt++) {
			for(int i=H-1; i>0; i--) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == 0) {
						map[i][j] = map[i-1][j];
						map[i-1][j] = 0;
					}
				}
			}
		}
	}
	
	public static int remain(int[][] map) {
		int cnt = 0;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] > 0) cnt++;
			}
		}
		
		return cnt;
	}
	
	public static int[][] copy(int[][] map){
		int[][] copy = new int[H][W];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		return copy;
	}
	
	static class Position{
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
