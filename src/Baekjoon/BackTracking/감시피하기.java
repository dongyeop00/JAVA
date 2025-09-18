package Baekjoon.BackTracking;

import java.util.*;
import java.io.*;

public class 감시피하기 {
	
	static int N;
	static int[][] map;
	static List<Position> teachers;
	static boolean canRun;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		teachers = new ArrayList<>();
		canRun = false;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				String str = st.nextToken();
				if(str.equals("S")) {
					map[i][j] = 1;
				}else if(str.equals("T")) {
					map[i][j] = 2;
					teachers.add(new Position(i,j));
				}else {
					map[i][j] = 0;
				}
			}
		}
		
		backTracking(0);
		if(canRun) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public static void backTracking(int depth) {
		if(depth == 3) {
			if(check()) {
				canRun = true;
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 3;
					backTracking(depth+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static boolean check() {
		for(Position t : teachers) {
			
			for(int d=0; d<4; d++) {
				int newX = t.x;
				int newY = t.y;
				
				while(true) {
					newX += dx[d];
					newY += dy[d];
					
					if(newX < 0 || newY < 0 || newX >= N || newY >= N) break;
					if(map[newX][newY] == 3) break;
					
					if(map[newX][newY] == 1) return false;
				}
			}
		}
		return true;
	}
	
	public static class Position{
		int x;
		int y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
