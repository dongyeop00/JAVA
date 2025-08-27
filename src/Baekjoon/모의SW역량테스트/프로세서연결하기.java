package Baekjoon.모의SW역량테스트;

import java.util.*;
import java.io.*;

public class 프로세서연결하기 {
	
	static int N;
	static int[][] map;
	static List<int[]> list;
	static int bestConnected, bestLength;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != 0 && j != 0 && i != N-1 && j != N-1) {
						if(map[i][j] == 1) {
							list.add(new int[] {i, j});
						}
					}
				}
			}
			
			bestConnected = -1; // 최대로 연결된 코어 수
			bestLength = Integer.MAX_VALUE; // 최대로 연결된 전선 수
			
			dfs(0 , 0, 0);
			
			System.out.println("#" + testCase + " " + bestLength);
		}
	}
	
	public static void dfs(int index, int connected, int length) {
        int remaining = list.size() - index;
        
        // 가지치기 : 남은 코어 연결해도 많이 연결한것보다 작으면 return;
        if (connected + remaining < bestConnected) return;

        if (index == list.size()) {
            if (connected > bestConnected) { // 최대한 많은 Core에 전원을 연결하였을 경우, 전선 길이의 합을 구하고자 한다.
                bestConnected = connected;
                bestLength = length;
            } else if (connected == bestConnected && length < bestLength) { //단, 여러 방법이 있을 경우, 전선 길이의 합이 최소가 되는 값을 구하라.
                bestLength = length;
            }
            return;
        }
        
        int x = list.get(index)[0];
        int y = list.get(index)[1];
        
        // 4방으로 깔아보기
        for(int d=0; d<4; d++) {
        	int len = testConnectLine(x, y, d); //연결할 수 있는지 확인
        	if(len == 0 ) continue;
        	
        	connectLine(x, y, d, len);
        	dfs(index+1, connected+1, length + len);
        	unconnectLine(x, y, d, len);
        	
        }
        
        dfs(index+1, connected, length);
	}

	public static int testConnectLine(int x, int y, int dir) {
		int newX = x + dx[dir];
		int newY = y + dy[dir];
		int count = 0;
		
		while(x >= 0 && y >= 0 && x < N && y < N) {
			// 중간에 선이 있거나, 다른 코어가 있을 경우 연결 못함
			if(map[newX][newY] != 0) return 0;
			count++;
			
			// 맨 끝에 도달했을 경우
			if(newX == 0 || newY == 0 || newX == N-1 || newY == N-1) return count;
			newX += dx[dir];
			newY += dy[dir];
		}
		
		return 0;
	}
	
	public static void connectLine(int x, int y, int dir, int len) {
		for(int i=0; i<len; i++) {
			x += dx[dir];
			y += dy[dir];
			
			map[x][y] = 2;
		}
	}
	
	public static void unconnectLine(int x, int y, int dir, int len) {
		for(int i=0; i<len; i++) {
			x += dx[dir];
			y += dy[dir];
			
			map[x][y] = 0;
		}
	}
}
