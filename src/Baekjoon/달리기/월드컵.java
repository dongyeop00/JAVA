package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 월드컵 {
	
	static int TEAM = 6;
	static int MATCH = 15; // 6C2
	static int[][] pairs = new int[MATCH][2];
	static int[][] game = new int[TEAM][3];
	static boolean can = false;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 매칭 쌍 생성
		makePair();
		
		for(int testCase=0; testCase<4; testCase++) {
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<TEAM; i++) {
				game[i][0] = Integer.parseInt(st.nextToken()); // win
				game[i][1] = Integer.parseInt(st.nextToken()); // draw
				game[i][2] = Integer.parseInt(st.nextToken()); // lose
			}
			
			can = false;
			
			if(isValid()) {
				DFS(0);
			}
			sb.append(can ? "1" : "0").append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	public static void DFS(int index) {
		if(can) return;
		if(index == MATCH) {
			can = true;
			return;
		}
		
		int a = pairs[index][0];
		int b = pairs[index][1];
		
		// win
		if(game[a][0] > 0 && game[b][2] > 0) {
			game[a][0]--; game[b][2]--;
			DFS(index+1);
			game[a][0]++; game[b][2]++;
		}
		
		// draw
		if(!can && game[a][1] > 0 && game[b][1] > 0) {
			game[a][1]--; game[b][1]--;
			DFS(index+1);
			game[a][1]++; game[b][1]++;
		}
		
		// lose
		if(!can && game[a][2] > 0 && game[b][0] > 0) {
			game[a][2]--; game[b][0]--;
			DFS(index+1);
			game[a][2]++; game[b][0]++;
		}
	}
	
	public static boolean isValid() {
		int totalWin = 0;
		int totalDraw = 0;
		int totalLose = 0;
		
		for(int i=0; i<TEAM; i++) {
			if(game[i][0] + game[i][1] + game[i][2] != 5) {
				return false;
			}
			
			totalWin += game[i][0];
			totalDraw += game[i][1];
			totalLose += game[i][2];
		}
		
		if(totalWin != totalLose) {
			return false;
		}
		
		if(totalDraw % 2 != 0) {
			return false;
		}
		
		return true;
	}
	
	public static void makePair() {
		int index = 0;
		for(int i=0; i<TEAM; i++) {
			for(int j=i+1; j<TEAM; j++) {
				pairs[index][0] = i;
				pairs[index][1] = j;
				index++;
			}
		}
		
		/*
		 * [pairs] -> 1번 경기했던 팀이랑은 경기 안함
		 * number	A	B
		 * 0		0	1
		 * 1		0	2
		 * 2		0	3
		 * 3		0	4
		 * 4		0	5
		 * 5		1	2
		 * 6		1	3
		 * 7		1	4
		 * 8		1	5
		 * 9		2	3
		 * 10		2	4
		 * 11		2	5
		 * 12		3	4
		 * 13		3	5
		 * 14		4	5
		 * 
		 */
	}


}
