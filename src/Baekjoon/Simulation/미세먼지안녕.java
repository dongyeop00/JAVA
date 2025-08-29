package Baekjoon.Simulation;

import java.util.*;
import java.io.*;

/*
 * 1. 확산 가능한 칸 탐색 (4방탐색)
 * 2. 확산되는 양 : map[r][c] / 5
 * 3. map[r][c] - map[r][c] / 5 * 확산가능한 칸
 */


public class 미세먼지안녕 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		// 0번 인덱스 : 위 / 1번 인덱스 : 아래
		int[] air = new int[2];
		int airIndex = 0;
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					air[airIndex++] = i;
				}
			}
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int time=0; time<T; time++) {
			int[][] sumMap = new int[R][C];
			
			// 1. 미세먼지 확산
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] > 0) {
						int count = 0;
						List<int[]> list = new ArrayList<>();
						
						// 1.1 확산 가능한 칸 탐색
						for(int d=0; d<4; d++) {
							int newX = i + dx[d];
							int newY = j + dy[d];
							
							if(newX < 0 || newY < 0 || newX >= R || newY >= C) continue;
							if(map[newX][newY] == -1) continue;
							
							count++;
							list.add(new int[] {newX, newY});
						}
						
						// 1.2 확산 가능한 양
						int spread = map[i][j] / 5;
						
						// 1.3 남은 미세먼지의 양
						int remain = map[i][j] - ((map[i][j]/5) * count);
						
						// 1.4 확산하기
						for(int[] arr : list) {
							sumMap[arr[0]][arr[1]] += spread;
						}
						
						sumMap[i][j] += remain;
					}
				}
			}
			
			// 2. 정리
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] == -1) continue;
					map[i][j] = sumMap[i][j];
				}
			}
			
			// 3. 공기청정기 작동
			// 3.1 윗동네
			int airPosition = air[0];
			// 왼쪽 이동
			for(int i=airPosition-1; i>0; i--) {
				map[i][0] = map[i-1][0];
			}
			// 맨위 이동
			for(int i=0; i<C-1; i++) {
				map[0][i] = map[0][i+1];
			}
			// 오른쪽 이동
			for(int i=0; i<airPosition; i++) {
				map[i][C-1] = map[i+1][C-1];
			}
			// 아래 이동
			for(int i=C-1; i>1; i--) {
				map[airPosition][i] = map[airPosition][i-1];
			}
			map[airPosition][1] = 0;
			
			
			// 3.2 아랫동네
			airPosition = air[1];
			// 왼쪽 이동
			for(int i=airPosition+1; i<R-1; i++) {
				map[i][0] = map[i+1][0];
			}
			// 아래 이동
			for(int i=0; i<C-1; i++) {
				map[R-1][i] = map[R-1][i+1];
			}
			// 오른쪽 이동
			for(int i=R-1; i>airPosition; i--) {
				map[i][C-1] = map[i-1][C-1];
			}
			// 맨위 이동
			for(int i=C-1; i>1; i--) {
				map[airPosition][i] = map[airPosition][i-1];
			}
			map[airPosition][1] = 0;
		}
		
		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != -1) {
					result += map[i][j];
				}
			}
		}
		System.out.println(result);
	}

}
