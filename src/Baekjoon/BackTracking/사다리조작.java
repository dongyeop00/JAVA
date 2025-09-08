package Baekjoon.BackTracking;

import java.util.*;
import java.io.*;

public class 사다리조작 {
	
	static int N, M, H;
	static boolean[][] link;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N개의 세로선
		M = Integer.parseInt(st.nextToken()); // M개의 가로선
		H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 위치의 개수
		
		link = new boolean[H+1][N+1];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			link[a][b] = true; // a랑 b가 연결되어 있음
		}

		int result = -1;
		
		// 다리를 총 0개부터 3개까지 놓을 수 있음
		for(int i=0; i<4; i++) {
			// 1개를 놓을 수 있다면
			if(backTracking(1, 1, 0, i)) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}
	
	
	/**
	 * 가로선 놓기 백트래킹
	 * @param startX : 시작 x
	 * @param startY : 시작 y
	 * @param count : 다리를 놓은 개수
	 * @param limit : 다리를 놓을 수 있는 개수
	 * @return
	 */
	public static boolean backTracking(int startX, int startY, int count, int limit) {
		// basis part
		if(count == limit) {
			return canMove();
		}
		
		// inductive part
		for(int i=startX; i<=H; i++) {
			// 다음 행부터는 항상 1열부터 시작
			int ystart = (i == startX ? startY : 1);
			for(int j=ystart; j<=N-1; j++) {
				if(canBuild(i, j)) {
					link[i][j] = true;
					
					if(backTracking(i, j+1, count+1, limit)) {
						return true;
					}
					
					link[i][j] = false;
				}
			}
		}
		
		
		return false;
	}
	
	public static boolean canBuild(int x, int y) {
		if(y < 1 || y > N-1) return false; // 범위 : 열은 1 ~ N-1만 유효
		if(link[x][y]) return false; // 이미 사다리가 있음
		if(1 <= y-1 && link[x][y-1]) return false; // 좌우 인접 금지
		if(y+1 <= N-1 && link[x][y+1]) return false; // 좌우 인접 금지
		return true;
	}
	
	public static boolean canMove() {
		for(int start=1; start<N+1; start++) { // 내려가는 목표 번호
			int y = start;
			for(int x=1; x<H+1; x++) { // link로 연결 되었는지 확인
				if(y <= N-1 && link[x][y]) {
					y++; // 밑으로 이동하면서 좌우 이동을 +1로 판단함
				}else if(1 <= y-1 && link[x][y-1]) {
					y--;
				}
			}
			// 도착 값과 시작 값이 다르다면 ? -> i번째 목표가 i번째로 들어오지 못했을 때
			if(y != start) return false;
		}
		//반복문에서 안걸러졌으면 모든 i번째 목표가 i번째로 들어왔음
		return true;
	}

}
