package Baekjoon.모의SW역량테스트;

import java.util.*;
import java.io.*;

public class 미생물격리3 {

	static int N, M, K;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<Bug> bugs;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			bugs = new ArrayList<>();
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				bugs.add(new Bug(x, y, cnt, dir));
			}
			
			for(int i=0; i<M; i++) {
				
				// 1. 미생물 이동
				for(Bug b : bugs) {
					b.x += dx[b.dir - 1];
					b.y += dy[b.dir - 1];
				}
				
				// 2. 가장자리 판별
				for(int j=bugs.size()-1; j>=0 ; j--) {
					Bug b = bugs.get(j);
					
					// 가장자리에 있다면
					if(b.x == 0 || b.y == 0 || b.x == N-1 || b.y == N-1) {
						b.cnt /= 2;
						int bDir = b.dir;
						if(bDir == 1) b.dir = 2;
						else if(bDir == 2) b.dir = 1;
						else if(bDir == 3) b.dir = 4;
						else if(bDir == 4) b.dir = 3;
					}
					
					if(b.cnt == 0) bugs.remove(j);
				}
				
				// 3. 합체
				// 2차원좌표를 1차원으로 변경 후 벌레 저장 -> 해당 좌표에 3개 이상 있을 수 있음
				Map<Integer, List<Bug>> map = new HashMap<>();
				List<Bug> newBugs = new ArrayList<>();
				
				for(Bug b : bugs) {
					int key = b.x * N + b.y;
					map.computeIfAbsent(key, k -> new ArrayList<>()).add(b);
				}
				
				for(List<Bug> group : map.values()) {
					if(group.size() == 1) {
						newBugs.add(group.get(0));
					}else {
						int cntSum = 0;
						Bug maxBug = null;
						
						for(Bug b : group) {
							cntSum += b.cnt;
							
							if(maxBug == null || b.cnt > maxBug.cnt) {
								maxBug = b;
							}
						}
						
						maxBug.cnt = cntSum;
						newBugs.add(maxBug);
					}
				}
				
				bugs = newBugs;
			}
			
			int count = 0;
			
			for(Bug b : bugs) {
				count += b.cnt;
			}
			
			System.out.println("#" + testCase + " " + count);
		}
	}
	
	public static class Bug{
		int x, y, cnt, dir;
		
		Bug(int x, int y, int cnt, int dir){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
}
