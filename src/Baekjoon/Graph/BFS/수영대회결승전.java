package Baekjoon.Graph.BFS;
import java.io.*;
import java.util.*;

public class 수영대회결승전 {

	static int N;
	static int[][] map;
	static boolean[][][] visited;
	static Position start;
	static Position end;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			visited = new boolean[3][N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			start = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			end = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}
	
	static class Position{
		int x;
		int y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
