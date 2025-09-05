package Baekjoon.모의SW역량테스트;

import java.util.*;
import java.io.*;

public class 보호필름 {

	static int D, W, K, min;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			map = new int[D][W];
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 투여 안해도 될 때
			if(K == 1) {
				System.out.println("#" + testCase + " " + 0);
				continue;
			}

			dfs(0, 0);
			System.out.println("#" + testCase + " " + min);
		}

	}
	
	public static void dfs(int x, int count) {
		// basis part
		if(count >= min) {
			return;
		}
		
		if(x == D) {
			if(test()) {
				min = Math.min(min, count);
			}
			return;
		}
		
		// inductive part
		// 약품 주입 안함
		dfs(x+1, count);
		
		int[] temp = map[x].clone();
		
		// A 약품 주입
		Arrays.fill(map[x], 0);
		dfs(x+1, count+1);
		
		// B 약품 주입
		Arrays.fill(map[x], 1);
		dfs(x+1, count+1);
		
		// 원상 복구
		map[x] = temp;
	}
	
	public static boolean test() {
		for(int y=0; y<W; y++) {
			int count = 1; // 연속된 개수
			boolean ok = false;
			for(int x=1; x<D; x++) {
				if(map[x][y] == map[x-1][y]) {
					count++;
				}else {
					count = 1;
				}
				
				// 이번 열은 통과
				if(count >= K) {
					ok = true;
					break;
				}
			}
			
			// 조건 x 전체 실패
			if(!ok) return false;
		}
		return true;
	}

}
