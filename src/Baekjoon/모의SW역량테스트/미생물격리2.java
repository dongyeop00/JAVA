package Baekjoon.모의SW역량테스트;

import java.util.*;
import java.io.*;

public class 미생물격리2 {
	
	static int N, M, K;
	static List<Bug> list;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};

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
			list = new ArrayList<>();
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				list.add(new Bug(x, y, cnt, dir));
			}
			
			for(int i=0; i<M; i++) {
				// 이동하기
				moveBug();
				
				// 제거하기
				removeBug();
				
				// 합치기
				sumBug();
			}
			
			int result = countBug();
			System.out.println("#" + testCase + " " + result);
		}
	}
	
	public static void moveBug() {
		for(Bug b : list) {
			b.x += dx[b.dir];
			b.y += dy[b.dir];
		}
	}
	
	public static void removeBug() {
		for(int i=list.size()-1; i>=0; i--) {
			Bug current = list.get(i);
			
			if(current.x == 0 || current.y == 0 || current.x == N-1 || current.y == N-1) {
				current.cnt /= 2;
				if(current.dir == 1) current.dir = 2;
				else if(current.dir == 2) current.dir = 1;
				else if(current.dir == 3) current.dir = 4;
				else current.dir = 3;
			}
			
			if(current.cnt == 0) list.remove(i);
		}
	}
	
	public static void sumBug() {
		Map<Integer, List<Bug>> map = new HashMap<>();
		
		for(Bug b : list) {
			int key = b.x * N + b.y;
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(b);
		}
		
		List<Bug> next = new ArrayList<>();
		
		for(List<Bug> group : map.values()) {
			if(group.size() == 1) {
				next.add(group.get(0));
			}else {
				int sum = 0;
				Bug maxBug = null;
				
				for(Bug b : group) {
					sum += b.cnt;
					
					if(maxBug == null || maxBug.cnt < b.cnt) maxBug = b;
				}
				
				maxBug.cnt = sum;
				next.add(maxBug);
			}
		}
		
		list = next;
	}
	
	public static int countBug() {
		int count = 0;
		
		for(Bug b : list) {
			count += b.cnt;
		}
		
		return count;
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
